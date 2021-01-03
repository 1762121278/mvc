package com.dfgx.user.annotation;


import java.lang.annotation.*;

/**
 * @author Today
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)//Resource,Class,Runtime
@Target(ElementType.METHOD)
public @interface LogAnnotation {
    String value() default "";
}
