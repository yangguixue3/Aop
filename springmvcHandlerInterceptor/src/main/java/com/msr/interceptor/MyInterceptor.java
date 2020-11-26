package com.msr.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * 1.实现 HandlerInterceptor 重写
 * 2.springMVC 配置
 *
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     *preHandle 该方法在Controller之前 执行
     * 返回值 true:放行，执行下一个拦截器，如果没有执行controller
     *       false:不放行，到就这里结束了
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor.preHandled 预先处理 拦截了。。。");
//        request.setAttribute("errors","请先登录，在...");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
//        return false;
        return true;
    }

    /**
     * postHandle
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor.postHandle controller后置拦截了。。。");
    }
    /**
     * afterCompletion jsp(指服务器编译jsp)页面执行后执行，返回html页面给浏览器
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("jsp(指服务器编译jsp)页面执行后执行，返回html页面给浏览器");

    }
}
