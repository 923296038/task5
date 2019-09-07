<%--
  Created by IntelliJ IDEA.
  User: 92329
  Date: 2019/9/4
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>错误</title>
</head>
<body>
操作失败!<br>
错误原因:<br>
<%--error接受错误信息--%>
<c:if test="${allErrors!=null}">
    <c:forEach items="${allErrors}" var="Error">
        ${Error.defaultMessage}<br><br>
    </c:forEach>
</c:if>
<c:if test="${dupliErrors!=null}">
    ${dupliErrors}
</c:if>
${not_matchErrors}
<a href="/Task5/toNewUser">重新填写</a>
</body>
</html>
