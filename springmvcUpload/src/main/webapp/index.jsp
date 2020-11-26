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
    <title> 上传文件</title>
</head>
<body>
<h2> 传统方式　servlet request</h2>
<form method="post" action="/upload/servletUpload" enctype="multipart/form-data">
    <input type="text" name="name" id="abc"><br>
    <input type="file" name="file" id="upload"><br>
    <input type="submit" value="上传文件"><br>
</form>

<h2> 　springMVC </h2>
<form method="post" action="/upload/servletUpload02" enctype="multipart/form-data">
    <input type="text" name="name" id="abc1"><br>
    <%--   name="upload" 与  MultipartFile upload 保持一致，否则报空指针 --%>
    <input type="file" name="upload" id="upload1"><br>
    <input type="submit" value="上传文件"><br>
</form>
<a href="/exception/test">此处抛出的是自定义的异常</a><br>
<a href="/exception/test1">此处抛出的系统运行时异常</a>

</body>
</html>
