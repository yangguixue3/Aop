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
<h1>@modelAttribute 无返回值</h1>
<h2>模拟通过用户密码修改 生日 信息 @ModelAttribute 在方法上  无返回值</h2>
<form action="test1/testModelAttribute" method="post">
    姓名:<input type="text" name="userName" value=""><br>
    密码:<input type="password" name="password" value=""><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
