package com.msr.controller;

import com.msr.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * パラメータ　demo
 */
@Controller
@RequestMapping("/account")
public class HelloController {
//    @RequestMapping(value = "/hello",method = {RequestMethod.POST,RequestMethod.GET},params = {"username=CaoMing","money"},headers = {"User-Agent"})
    @RequestMapping(value = "/hello",method = {RequestMethod.POST,RequestMethod.GET},params = {"username=CaoMing","money"})
    public  String sayHello(){
        System.out.println("username 匹配到");
        return "success";
    }

    /**
     * url携带参数 框架自动匹配
     * @param username
     * @param age
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username,Integer age){
        System.out.println("testParam  Spring ! ");
        System.out.println(username + " : " + age);
        return "success";
    }

    /**
     * 表单 普通参数
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("/testSimpleType")
    public String testSimpleType(String name,String password){
        System.out.println(name + " : " + password);
        return "success";
    }

    /**
     * JavaBean
     * @param account
     * @return
     */
    @RequestMapping("/testJavaBean")
    public String testJavaBean(Account account){
        System.out.println("account = " + account);
        return "success";
    }
}
