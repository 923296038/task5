<%--
  Created by IntelliJ IDEA.
  User: 92329
  Date: 2019/8/30
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
${msg}
<form action="${pageContext.request.contextPath }/login" method="post">
    用户名：<input type="text" name="user_name" /><br>
    密码：<input type="password" name="password" /><br>
    <input type="submit" value="登录" />
    <a href="/Task5/toNewUser">注册</a>
</form>
</body>
</html>
