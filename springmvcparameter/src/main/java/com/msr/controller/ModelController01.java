package com.msr.controller;

import com.msr.domain.User1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 *model
 */
@Controller
@RequestMapping("/test1")
public class ModelController01 {
    /**
     * Model 的设定值为 request 域
     */
    @RequestMapping("/model")
    public String testModelAttribute(Model model) {

        User1 user1 = new User1("小米","123456",new Date());
        model.addAttribute("msg",user1);
        System.out.println("user1 = " + user1);
        return "success1";
    }


}
