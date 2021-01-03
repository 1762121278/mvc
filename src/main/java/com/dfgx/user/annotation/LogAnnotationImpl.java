package com.dfgx.user.annotation;


import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author Today
 */
@Aspect
@Component
public class LogAnnotationImpl {

    @Pointcut("@annotation(com.dfgx.user.annotation.LogAnnotation)")
    public void timeOut(){ };

    @After("timeOut()")
    public void getLog(){
        Logger log = Logger.getLogger(Config.log.toString());
        log.info("print log");
        System.out.println("print log");
    }
}
