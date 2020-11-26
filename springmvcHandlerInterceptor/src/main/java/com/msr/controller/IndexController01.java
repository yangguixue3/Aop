package com.msr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 拦截器
 */
@Controller
@RequestMapping("/Interceptor01")
public class IndexController01 {
    /**
     *
     */
    @RequestMapping(value="/hello01")
    public String servletUpload()  {
        System.out.println("IndexController01 执行。。。。");
        return "success";
    }
}
