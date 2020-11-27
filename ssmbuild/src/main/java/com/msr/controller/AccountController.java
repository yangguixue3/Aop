package com.msr.controller;

import com.msr.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @RequestMapping("/queryAll")
    public String queryAll(){
        System.out.println("Controller 执行了 queryAll ....");
        accountService.queryAll();
        return "success";
    }
}
