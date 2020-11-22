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
    <title>spring 入门</title>
</head>
<body>
<h1>spring 入门</h1>
<a href="${pageContext.request.contextPath}/account/hello">无参数</a><br>
<a href="${pageContext.request.contextPath}/account/hello?username=liSi&money">username参数不匹配</a><br>
<a href="${pageContext.request.contextPath}/account/hello?username=CaoMing&money=11">username参数正常匹配</a><br>
<a href="account/hello?username=CaoMing&age=20&money=100">username参数匹配,且有多余参数u</a><br>
<a href="account/testParam?username=CaoMing&age=20&money=100">框架自动匹配参数,要求前后一致</a><br>
<hr>
<h1>基本数据类型和String</h1>
<%-- 普通表单--%>
<form action="account/testSimpleType" method="post">
    账号:<input type="text" name="name" value=""><br>
    密码:<input type="password" name="password" value=""><br>
    <input type="submit" value="提交">
</form>

<%--<h1>JavaBean</h1>--%>
<%--<form action="account/testJavaBean" method="post">--%>
<%--    账号:<input type="text" name="accountName" value=""><br>--%>
<%--    密码:<input type="password" name="password" value=""><br>--%>
<%--    金额:<input type="number" name="money" value=""><br>--%>

<%--    用户姓名:<input type="text" name="user.username" value=""><br>--%>
<%--    用户年龄:<input type="number" name="user.age" value=""><br>--%>
<%--    <input type="submit" value="提交">--%>
<%--</form>--%>


<h1>JavaBean 中的 Bean List 与 Map</h1>
<form action="/account/testJavaBean" method="post">
    <h2>普通类型的javaBean</h2>
    账号:<input type="text" name="accountName" value=""><br>
    密码:<input type="password" name="password" value=""><br>
    金额:<input type="number" name="money" value=""><br>
    <h2>javaBean中UserBean</h2>
    用户姓名:<input type="text" name="user.username" value=""><br>
    用户年龄:<input type="number" name="user.age" value=""><br>
    <h2>javaBean中List</h2>
    用户姓名:<input type="text" name="userList[0].username" value=""><br>
    用户年龄:<input type="number" name="userList[0].age" value=""><br>
    <%--MAP--%><h2>javaBean中Map</h2>
    用户姓名:<input type="text" name="userMap['one'].username" value=""><br>
    用户年龄:<input type="number" name="userMap['one'].age" value=""><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
