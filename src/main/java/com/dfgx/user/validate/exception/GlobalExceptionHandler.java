//package com.dfgx.user.validate.exception;
//
//import com.dfgx.user.validate.Bean.Result;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpRequest;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//@ResponseBody
//public class GlobalExceptionHandler {
//
//    public final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//
//    @ExceptionHandler(value = Exception.class)
//    public Result exceptionHandler(HttpRequest request,Exception e) {
//        logger.info(Result.FAIL.getMessage());
//        e.printStackTrace();
//        return Result.FAIL;
//    }
//}
