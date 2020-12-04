package com.msr.myException;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器,捕捉 预期异常
 * 1.实现HandlerExceptionResolver
 * 2.springMVC中注册
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        e.printStackTrace();

        //如果抛出的是系统自定义的异常则直接转换
        CustomException customException =null;
        if (e instanceof CustomException) {
            customException = (CustomException) e;
        }else {
            //如果抛出的不是系统自定义异常则重新构造一个系统错误异常。
            customException = new CustomException("系统未知错误");
        }
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.addObject("message",customException);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
