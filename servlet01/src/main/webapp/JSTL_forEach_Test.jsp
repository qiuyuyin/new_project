<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ForEach</title>
</head>
<body>
<%
    ArrayList<String> names = new ArrayList<>();
    names.add("1");
    names.add("2");
    names.add("3");
    names.add("4");
    names.add("5");
    request.setAttribute("list",names);
%>
<c:forEach var="name" items="${list}">
    <c:out value="${name}"/>
    <br>
</c:forEach>

<%--<c:forEach begin="2" end="3" step="2"/>--%>

</body>
</html>
