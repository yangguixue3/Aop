package com.msr.controller;

import com.msr.domain.UserDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
@Controller
@RequestMapping("/test")//  /test/date
public class AnnotationParameterController {
    /**
     *  1.文字列から日付へのコンバーターをつくる
     *  在Spring应用程序上下文中加载自定义时间转换器设置
     *  2.Spring アプリケーションコンテキストに　カスタム タイム コンバーターを読み込み
     *
     *  目的::::学习吧自己写的 转换器 加入到框架中,   日期 类型就能自动转换
     */
   @RequestMapping("/date")
    public String data(UserDate userDate) {
       System.out.println("userDate = " + userDate);
        return "success";
    }

    /**
     * 原始的 request
     */
    @RequestMapping("/servletApi")
    public String testHttpServlet(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println("request = " + request);
        System.out.println("response = " + response);
        System.out.println("session = " + session);
        return "success";
    }

    /**
     * URl 名 与参数 名不一致 @RequestParam
     *
     */
    @RequestMapping("/parameter")
    public String testParameter(@RequestParam("username") String name) {
        System.out.println("name = " + name);
        return "success";
    }

    /**
     * @RequestBody 只能用于post。
     *      注意 获取的是 请求体的所有内容，
     */
    @RequestMapping("/RequestBody")
    public String test( @RequestBody String userName) {
        System.out.println("name = " + userName);
        return "success";
    }

    /**
     *    @PathVariable  匹配 <a href="/PathVariable/10></a>
     *    匹配URL 占位符  不匹配<a href="/PathVariable></a>
     */
    @RequestMapping("/PathVariable/{sss}")
    public String test01( @PathVariable("sss") String id) {
        System.out.println("请求的是方法 test01" );
        System.out.println("name = " + id);
        return "success";
    }
    /**
     *    @PathVariable  匹配 <a href="/PathVariable/10></a>
     *    匹配URL 占位符
     */
    @RequestMapping("/PathVariable")
    public String test02( ) {
        System.out.println("请求的是方法 test02" );
        return "success";
    }
    /**
     *    @RequestHeader
     */
    @RequestMapping("/RequestHeader")
    public String testRequestHeader(@RequestHeader("User-Agent") String header) {
        System.out.println(header );
        return "success";
    }
    /**
     *    @CookieValue
     */
    @RequestMapping("/CookieValue")
    public String testCooker(@CookieValue("JSESSIONID") String cookie) {
        System.out.println("header = " + cookie);
        return "success";
    }


    @ModelAttribute
    public void  testModelAttribute() {
        System.out.println("执行了 testModelAttribute 方法。。。。");

    }

}
