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
    <title>spring 入门 annotation parameter</title>
</head>
<body>
<h1>Date 属性转换 及  /PathVariable/{sss}转换器 加入到框架中,   日期 类型就能自动转换</h1>
<form action="test/date" method="post">
    姓名:<input type="text" name="userName" value=""><br>
    密码:<input type="password" name="password" value=""><br>
    生日:<input type="text" name="birthday" value=""><br>

    <input type="submit" value="提交">
</form>
<hr>
<a href="/test/servletApi">servlet request response</a><br>
<a href="/test/parameter?username=liSi">url名 与参数不一致</a><br>
<a href="/test/parameter">url没有参数请求不成功</a><br>
<hr>
<h2>@RequestBody</h2>
<form action="/test/RequestBody" method="post">
    姓名:<input type="text" name="userName" value="参数@RequestBody"><br>
    密码:<input type="password" name="password" value=""><br>
    <input type="submit" value="提交">
</form>
<hr>
<h2>@PathVariable</h2>
<a href="/test/PathVariable">url没有参数请求</a><br>
<a href="/test/PathVariable/123456">有占位符请求</a><br>
<a href="/test/PathVariable/123466/abcde">有占位符，url格式 多个/abce  不成功</a><br>
<h2>@RequestHeader</h2>
<a href="/test/RequestHeader">RequestHeader</a><br>
<h2>@CookieValue</h2>
<a href="/test/CookieValue">CookieValue</a><br>




</body>
</html>
