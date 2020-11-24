package com.msr.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解  MyColumn
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyColumn {
        String value();
}
