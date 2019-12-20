package com.chen.elegant.aop;

import com.chen.elegant.utils.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Aspect
//@Component
public class LogAspect {

    //定义一个切点
    @Pointcut("execution(* com.chen.elegant.controller..*.*(..))")
    private void log(){}

    //方法调用前执行before
    @Before("log()")
    private void before(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("============================ request url：" + request.getRequestURL());

        StringBuffer sb = new StringBuffer();
        Object[] objects = joinPoint.getArgs();
        for (Object o:objects) {
            if (o instanceof HttpSession ||o instanceof HttpServletResponse || o instanceof HttpServletRequest|| o instanceof  Exception) {
                continue;
            }
            sb.append(GsonUtil.toJson(o) + ",");
        }
        log.info("============================ request parameters：" + sb.toString());
    }

    //方法调用之后有返回值执行AfterReturning
    @AfterReturning(returning = "ret",pointcut = "log()")
    private void afterReturning(Object ret){
        // 处理完请求，返回内容
        log.info("============================ response contents: " + GsonUtil.toJson(ret));
    }
}
