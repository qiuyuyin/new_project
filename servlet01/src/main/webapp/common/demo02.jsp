<%--
  Created by IntelliJ IDEA.
  User: 伊离
  Date: 2020/12/12
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo02</title>
</head>
<body>

<%@include file="../index.jsp"%>
<jsp:include page="../index.jsp"/>
<jsp:include page="demo02.jsp" flush="true">

</jsp:include>
</body>
</html>
