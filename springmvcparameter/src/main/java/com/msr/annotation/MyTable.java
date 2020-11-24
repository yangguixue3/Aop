package com.msr.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解  MyTable
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface MyTable {
    String value() default "表明为空";
}
