package com.msr.annotation;

import java.lang.annotation.*;

/**
 * 自定义
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Writer {
    String name();
    int age();
}
