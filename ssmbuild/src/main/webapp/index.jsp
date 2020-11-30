<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2020/11/27
  Time: 下午 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>首页</h2>
    <a href="<%=request.getContextPath()%>/Account/queryAll">查询所有账号信息</a>
    <h2>新增账户</h2>
    <form action="/Account/insertAccount" method="post">
        账号:<input type="text" name="name" id=""><br>
        金额:<input type="text" name="money" id=""><br>
        <input type="submit" value="保存">
    </form>

</body>
</html>
