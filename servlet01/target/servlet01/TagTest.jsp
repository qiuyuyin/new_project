<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL核心标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--<jsp:forward page="index.jsp">--%>
<%--    <jsp:param name="name" value="yili"/>--%>
<%--    <jsp:param name="age" value="12"/>--%>
<%--</jsp:forward>--%>

<h4>if:Test</h4>

<form action="TagTest.jsp" method="get">
    <input type="text" name="username" value="${param.username}">
    <input type="submit" value="登录">
</form>

<c:if test="${param.username=='admin'}" var="isAdmin">
    <c:redirect url="http://localhost:8080/servlet01_war/"/>
</c:if>

</body>
</html>
