package com.msr.controller;

import com.msr.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Ajax:
 */
@Controller
@RequestMapping("/user")
public class AjaxController {

    /**
     * 1. @RequestBody  获取请求体
     */
//    @RequestMapping(value = "/hello1")
//    public  String sayHello1(@RequestBody String body){
//        System.out.println("body = " + body);
//        return "success";
//    }

    /**
     * 2. @RequestBody  获取请求,转换为 User 类型参数
     *                  需要jar包支持 jackson 三个
     */
    @RequestMapping(value = "/hello1")
    @ResponseBody
    public  User sayHello2(@RequestBody User user){
        System.out.println("user = " + user);
        user.setUsername("kitty");
        user.setAge(100);
        //返回响应，这里不需要转json,方法上有@ResponseBody

        return user;
    }

}
