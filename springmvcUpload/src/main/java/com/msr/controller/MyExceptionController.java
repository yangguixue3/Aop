package com.msr.controller;

import com.msr.myException.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/exception")
public class MyExceptionController {
    @RequestMapping(value="/test")
    public String testException() throws CustomException {
        System.out.println("MyExceptionController...");
        try {
            int a = 10/0;
        } catch (Exception e) {
            e.printStackTrace();
            //此处抛出异常 通过框架由自定义异常捕捉
            throw new CustomException("没有用户名或网络连接缓慢，请等待");
        }
        return "success";
    }

    /**
     *抛出RuntimeException
     */
    @RequestMapping(value="/test1")
    public String testException01(){
        System.out.println("MyExceptionController...");
        try {
            int a = 10/0;
        } catch (Exception e) {
            e.printStackTrace();
            //此处抛出异常 通过框架由自定义异常捕捉
            throw new RuntimeException("没有用户名或网络连接缓慢，请等待");
        }
        return "success";
    }
}
