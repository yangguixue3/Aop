package com.msr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 拦截器
 */
@Controller
@RequestMapping("/Interceptor")
public class IndexController {
    /**
     *
     */
    @RequestMapping(value="/hello")
    public String servletUpload()  {
        System.out.println("IndexController 执行。。。。");
        return "success";
    }
}
