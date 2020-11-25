package com.msr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Ajax:
 */
@Controller
@RequestMapping("/user")
public class IndexController {
    /**
     * 1. 响应数据-返回值类型为字符串
     */
    @RequestMapping(value = "/hello")
    public  String sayHello(){
        System.out.println("响应数据-字符串");
        return "success";
    }

    /**
     * 2. 响应数据-返回值类型为void
     *      2.1、使用 request 转向页面，转发
     */
    @RequestMapping(value = "/hello01")
    public  void  sayHello1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("响应数据-void 使用 request 转向页面 转发");
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
    }

    /**
     * 2. 响应数据-返回值类型为void
     *      2.2、使用 response 重定向，
     */
    @RequestMapping(value = "/hello02")
    public  void  sayHello2(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("响应数据-void 使用 response 重定向");
        response.sendRedirect("/ajax.jsp");
    }
    /**
     * 2. 响应数据-返回值类型为void
     *      2.3、通过 response 指定响应结果
     */
    @RequestMapping(value = "/hello03")
    public  void  sayHello3(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("响应数据-void 通过 response 指定响应结果");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
//        response.setContentType("application/json;charset=utf-8");
//response.getWriter().write和 response.getWriter().print是响应给客户端的东西，如果不用ajax接收将数据放在合适的位置，就会在浏览器上生成一个新的页面来显示内容。
//        response.getWriter().write("json 串");
        response.getWriter().print("响应数据-void 通过 response 指定响应结果 ，成功 ...");
    }

    /**
     * 3. 响应数据-返回值类型为ModelAndView
     *
     */
    @RequestMapping(value = "/hello04")
    public ModelAndView sayHello4() throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","hello modelAndView");
        modelAndView.setViewName("success1");
        return modelAndView;
    }

    /**
     * 转发
     *
     */
    @RequestMapping(value = "/hello05")
    public String sayHello5() throws IOException {
        System.out.println("sayHello5 的  执行了。。。。转发");
        //使用请求
        //转发，既可以转发到 jsp，也可以转发到其他的控制器方法。
        return "forward:/WEB-INF/pages/success.jsp";
    }

    /**
     * 重定向
     *
     */
    @RequestMapping(value = "/hello06")
    public String sayHello6() throws IOException {
        System.out.println("sayHello6 的  执行了。。。。重定向");
        // 如果是重定向到 jsp 页面，则 jsp 页面不
        //能写在 WEB-INF 目录中，否则无法找到。
        return "redirect:/ajax.jsp";
    }





}
