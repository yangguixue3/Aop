# SpringMVC 中的拦截器 #

- 1.编写一个普通类实现 HandlerInterceptor 接口

```java
public class HandlerInterceptorDemo1 implements HandlerInterceptor{
    //重写方法
}
```

- 2.配置拦截器
  
```xml
    <!-- 拦截器 多个拦截情况，执行顺序 按拦截器的配置顺序 执行-->
    <mvc:interceptors>
        <mvc:interceptor>
            <!--  配置单个拦截器 -->
            <mvc:mapping path="/Interceptor/*"/>
            <mvc:exclude-mapping path=""/><!-- 用于指定排除的 url--> 
            <bean class="com.msr.interceptor.MyInterceptor"/>
        </mvc:interceptor>
        <mvc:interceptor>
        <!--    拦截所有路径请求    -->
            <mvc:mapping path="/**"/>
            <bean class="com.msr.interceptor.MyInterceptor01"/>
        </mvc:interceptor>
```
