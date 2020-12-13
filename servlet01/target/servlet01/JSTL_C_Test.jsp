
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="score" value="85"/>
<c:choose>
    <c:when test="${score>=90}">
        <c:out value="你的成绩为优秀"/>
    </c:when>
    <c:when test="${score>=80}">
        <c:out value="你的成绩为良好"/>
    </c:when>
    <c:when test="${score>=70}">
        <c:out value="你的成绩为一般"/>
    </c:when>
    <c:when test="${score>=60}">
        <c:out value="你的成绩为很差"/>
    </c:when>
</c:choose>
</body>
</html>
