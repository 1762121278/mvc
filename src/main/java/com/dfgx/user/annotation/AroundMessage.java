/*
package com.dfgx.user.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundMessage {

    @Pointcut("execution(* com.dfgx.user.controller..*.*(..))")
    private void cut(){
    }

    @After("cut()")
    public void getMes(){
        System.out.println("这是个环绕通知");
    }
}
*/
