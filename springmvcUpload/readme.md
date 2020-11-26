# SpringMVC 实现文件上传 #

## 文件上传 传统 通过request ##

- 1.文件上传的必要前提

```jsp
<form action="/fileUpload" method="post" enctype="multipart/></form>
```

- 2.编写Controller

## SpringMVC ##

- 1.jsp

```java
<form action="/fileUpload" method="post" enctype="multipart/></form>
```

-2.编写Controller
-3.配置文件解析器

```xml
    <!--配置 上传文件解析器对象-->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="maxUploadSize" value="10485760"/>
    </bean>

```


## SpringMVC 中的异常处理 ##

- 1.自定义异常 CustomException
  
```java

public class  CustomException extends Exception{
    private String message;
    public CustomException() {}
    public CustomException(String message) {
        this.message= message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}

```

- 2.自定义异常处理器

```java
public class CustomExceptionResolver implements HandlerExceptionResolver {
}
```

- 3.配置异常处理器

```xml
    <!-- 配置自定义异常处理器 -->
    <bean id="handlerExceptionResolver" class="com.msr.myException.CustomExceptionResolver"/>

```
