package com.msr.controller;

import com.msr.domain.User1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 *更新个人信息，通过方法上，＠ModelAttribute配置参数　获取用户数据
 */
@Controller
@RequestMapping("/test1")//  /test/date
public class ModelAttributeController02 {
    /**
     * 第一种:@ModelAttribute return
     */
    @ModelAttribute
    public void testModelAttribute(String userName, String age, Map<String, User1> map) {
        System.out.println("执行了 testModelAttribute 方法。。。。通过用户名和密码，查询生日");
        User1 user1 = new User1();
        user1.setUsername(userName);
        user1.setAge(age);
        //假设通过 用户名，密码从数据库查询到的 生日
        Date date = new Date();
        user1.setBirthday(date);
        System.out.println("date = " + date);
        map.put("abc",user1);
    }
    @RequestMapping("/testModelAttribute02")
    public String testModelAttribute(User1 user1) {

        System.out.println("user1 = " + user1);
        return "success";
    }


}
