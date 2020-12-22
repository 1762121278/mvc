package com.dfgx.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Configuration
public class AppMvcConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

/*
    //页面跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login.html").setViewName("login");
    }
*/
    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( myInterceptor).addPathPatterns("/user").excludePathPatterns("/user/select");
    }
}

