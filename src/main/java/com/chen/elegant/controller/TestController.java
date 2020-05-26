package com.chen.elegant.controller;

import com.chen.elegant.commom.JsonResult;
import com.chen.elegant.utils.CreateValidateCodeUtil;
import com.chen.elegant.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/elegant")
public class TestController {

//    @GetMapping("")
//    public String elegant(){
//        return "elegant";
//    }
//
//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }
//
//    @GetMapping(value = {"/","/index"})
//    public String test(Model model){
//        model.addAttribute("name","Shiro");
//        return "index";
//    }

    @ResponseBody
    @PostMapping("/login")
    public JsonResult login(@RequestBody Map<String,Object> map){

        String userName = (String) map.get("userName");
        String password = (String) map.get("password");
        boolean rememberMe = (boolean) map.get("rememberMe");
        /**
         * 使用shiro编写操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        log.info("加密前：{}，加密后：{}",password,MD5Utils.MD5EncodePassword(password));
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(userName, MD5Utils.MD5EncodePassword(password),rememberMe);

        //3.执行登录方法
        try {
            subject.login(token);
            //登录成功，跳转到index
            return new JsonResult(true, "登录成功");
        }catch (UnknownAccountException e){
            //登录失败：用户名不存在
            return new JsonResult(false, "用户名不存在");
        }catch (IncorrectCredentialsException e){
            //登录失败：密码错误
            return new JsonResult(false, "密码错误");
        }catch (LockedAccountException e){
            return new JsonResult(false,"帐号已被锁定");
        }catch (Exception e){
            return new JsonResult(false,e.getMessage());
        }
    }

    @GetMapping("/add")
    public String add(){
        return "/user/add";
    }

    @GetMapping("/update")
    public String update(){
        return "/user/update";
    }

    @GetMapping("/noAuthor")
    public String noAuth(){
        return "noAuthor";
    }

    /**
     * 退出登录
     * @param redirectAttributes
     * @return
     */
    @GetMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes) {
        // http://www.oschina.net/question/99751_91561
        // 此处有坑： 退出登录，其实不用实现任何东西，只需要保留这个接口即可，也不可能通过下方的代码进行退出
        // SecurityUtils.getSubject().logout();
        // 因为退出操作是由Shiro控制的
//        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "login";
    }

    //验证码
    @GetMapping("/getCode")
    public void getValidateCode(HttpServletResponse response) throws IOException {

        Subject subject = SecurityUtils.getSubject();
        //创建输出流
        OutputStream outputStream = response.getOutputStream();
        //获取session
        Session session = subject.getSession();
        //获取验证码
        CreateValidateCodeUtil createValidateCode = new CreateValidateCodeUtil();
        String generateVerifyCode = createValidateCode.getString();
        //将验证码存入session，做登录验证
        session.setAttribute("code",generateVerifyCode);
        log.info("验证码:[{}]",generateVerifyCode);
        //获取验证码图片
        BufferedImage image = createValidateCode.getImage();
        ImageIO.write(image, "png", outputStream);
        //关流
        outputStream.flush();
        outputStream.close();
    }
}
