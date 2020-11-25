<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2020/11/20
  Time: 上午 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>spring response 入门</title>
</head>
<body>
<h1> 响应数据和结果视图　</h1>
<a href="${pageContext.request.contextPath}/user/hello">响应数据-返回值类型为-字符串</a><br>
<a href="${pageContext.request.contextPath}/user/hello01">响应数据-返回值类型为void-request转发</a><br>
<a href="${pageContext.request.contextPath}/user/hello02">响应数据-返回值类型为void-response重定向</a><br>
<a href="${pageContext.request.contextPath}/user/hello03">响应数据-返回值类型为void-response 指定响应结果</a><br>
<a href="${pageContext.request.contextPath}/user/hello04">响应数据-返回值类型为ModelAndView</a><br>
<a href="${pageContext.request.contextPath}/user/hello05">响应数据-forward转发</a><br>
<a href="${pageContext.request.contextPath}/user/hello06">响应数据-Redirect 重定向</a><br>
<hr>
<h1>基本数据类型和String</h1>
<h1>ajax</h1>


</body>
</html>
