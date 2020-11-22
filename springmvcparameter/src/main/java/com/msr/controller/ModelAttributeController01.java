package com.msr.controller;

import com.msr.domain.User1;
import com.msr.domain.UserDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 *更新个人信息，少填了一项生日，后台查数据库数据，补齐缺省的信息
 */
@Controller
@RequestMapping("/test1")//  /test/date
public class ModelAttributeController01 {
    /**
     * 第一种:@ModelAttribute return
     */
    @ModelAttribute
    public User1 testModelAttribute(String userName,String age) {
        System.out.println("执行了 testModelAttribute 方法。。。。通过用户名和密码，查询生日");
        User1 user1 = new User1();
        user1.setUsername(userName);
        user1.setAge(age);
        //假设通过 用户名，密码从数据库查询到的 生日
        Date date = new Date();
        user1.setBirthday(date);

        return user1;
    }
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User1 user1) {

        System.out.println("user1 = " + user1);
        return "success";
    }


}
