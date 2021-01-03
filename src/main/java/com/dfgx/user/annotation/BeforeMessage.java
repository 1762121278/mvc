//package com.dfgx.user.annotation;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//public class BeforeMessage {
//
//    @Pointcut("execution(* com.dfgx.user.controller.*.*(..))")
//    public void cut(){
//    }
//
//    @Around("cut()")
//    public void before(ProceedingJoinPoint joinPoint){
//        Object[] args = joinPoint.getArgs();
//        Signature signature = joinPoint.getSignature();
//        String name = signature.getName();
//        Class declaringType = signature.getDeclaringType();
//        Object target = joinPoint.getTarget();
//        String kind = joinPoint.getKind();
//
//        for (Object arg : args) {
//            System.out.println(arg);
//        }
//        System.out.println("1 "+name);
//        System.out.println("2 "+declaringType);
//        System.out.println("3 "+signature);
//        System.out.println("4 "+target);
//        System.out.println("5 "+kind);
//    }
//}
