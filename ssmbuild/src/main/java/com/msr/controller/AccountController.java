package com.msr.controller;

import com.msr.domain.Account;
import com.msr.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @RequestMapping("/queryAll")
    public String queryAll(Model model){
        System.out.println("Controller 执行了 queryAll ....");
        List<Account> accounts = accountService.queryAll();
        System.out.println("accounts = " + accounts);
        model.addAttribute("queryAll",accounts);
        return "success";
    }
}
