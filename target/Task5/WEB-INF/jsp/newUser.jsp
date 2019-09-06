<%--
  Created by IntelliJ IDEA.
  User: 92329
  Date: 2019/9/4
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>用户注册</title>
</head>
<body>

<form action="" name="userForm">
    用户名 <input type="text" name="user_name"><br>
    密码 <input type="text" name="password"><br>
    重复输入密码 <input type="text" name="password_repeat"><br>
    昵称 <input type="text" name="nick_name"><br>
    邮箱 <input type="text" name="email"><br>
    手机号 <input type="text" name="mobile_number"><br>
    <input type="button" value="确认" onclick="newUser()">
</form>
<script type="text/javascript">
    function newUser() {
        var form = document.forms[0];
        form.action = "<%=basePath %>/newUser";
        form.method = "post";
        form.submit();
    }
</script>
</body>
</html>
