<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2020/11/20
  Time: 上午 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>spring response 入门</title>
<%--
    导入本地的 js jar包
    需要 1. springMVC 中配置， 告诉前端控制器,不要拦截静态资源
--%>
    <script src="js/jquery-3.4.1.min.js"></script>
<%--    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>--%>
    <script>
        $(function () {
            $("#btn").click(function () {
                alert("hello");
                $.ajax({
                    <%--url:"${pageContext.request.contextPath}/user/hello1",--%>
                    url:"user/hello1",
                    type:"POST",
                    // data:"name=山本&password=123456",　这是错误的
                    data:'{"username":"山本","age":23}',
                    async:true,
                    dataType:"json",//服务器返回的数据类型
                    contentType:"application/json;charset=UTF-8",
                    success:function (obj) {
                        console.log(obj);
                        console.log(typeof (obj));
                        // 获取 返回 数据
                        $("#btn").text(obj.username);
                    }
                })
            });
        })

    </script>
</head>
<body>
<h1>ajax</h1>
<button id="btn" value="sss">ajax请求</button>


</body>
</html>
