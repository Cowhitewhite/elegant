package com.chen.elegant.shiro;

import com.chen.elegant.entity.TbUserAdmin;
import com.chen.elegant.enums.UserStatusEnum;
import com.chen.elegant.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义realm类
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    /**
     * 执行认证逻辑
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("执行认证逻辑");
        //编写shiro判断逻辑
        //1.判断用户名
//        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();
        TbUserAdmin user = userService.findByAccount(username);
        if (user == null){
            throw new UnknownAccountException("账号不存在！");
        }
        if (user.getLocked() != null && UserStatusEnum.DISABLE.getCode().equals(user.getLocked())) {
            throw new LockedAccountException("帐号已被锁定，禁止登录！");
        }
        log.info("传过来的密码：{},数据库的密码：{}",token.getCredentials(),user.getLoginPassword());
        //2.判断密码
        return new SimpleAuthenticationInfo(
                user,
                user.getLoginPassword(),
                ByteSource.Util.bytes(username),
                getName());
    }

    /**
     * 执行授权逻辑
     * 此方法调用 hasRole,hasPermission的时候才会进行回调.
     *  权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * 需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，
     * 调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行授权逻辑");
        //给资源授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加资源的授权字符串
//        info.addStringPermission("user:elegant/add");
        //到数据库查询当前登录用户的授权字符串
        Subject subject = SecurityUtils.getSubject();
        TbUserAdmin user = (TbUserAdmin) subject.getPrincipal();
        TbUserAdmin dbUser = userService.findById(user.getAdminUserId());
//        info.addStringPermission(dbUser.getPerms());
        return info;
    }

}
