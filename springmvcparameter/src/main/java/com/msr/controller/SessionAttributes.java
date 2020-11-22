package com.msr.controller;

import com.msr.domain.User1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;

/**
 *model
 */
@Controller
@RequestMapping("/test2")
@org.springframework.web.bind.annotation.SessionAttributes(value = {"msg01","mst02"},types = {User1.class, String.class})
public class SessionAttributes {
    /**
     * Model 的设定值为 request 域
     */
    @RequestMapping("/testSessionAttributes")

    public String testSessionAttributes(Model model) {
        User1 user1 = new User1("小明","123456",new Date());
        model.addAttribute("msg01",user1);
        model.addAttribute("msg02","你好");

        return "success2";
    }
    @RequestMapping("/getModelGetAttributes")

    public String getModelGetAttributes(ModelMap modelMap) {
        System.out.println("获取session 中设置在 model中的值");
        System.out.println(modelMap.getAttribute("msg01"));
        System.out.println(modelMap.getAttribute("msg02"));

        return "success2";
    }
   @RequestMapping("/delModelGetAttributes")

    public String delModelGetAttributes(SessionStatus sessionStatus) {
       System.out.println("删除session中model中设置的值");
       sessionStatus.setComplete();


        return "success2";
    }

}
