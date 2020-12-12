<%@ page import="java.util.Enumeration" %>
<%@ page import="com.sun.nio.sctp.HandlerResult" %><%--
  Created by IntelliJ IDEA.
  User: 伊离
  Date: 2020/12/12
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Req</title>
</head>
<body>
<%
    Enumeration<String> headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()){
        String paramName = headerNames.nextElement();
        String header = request.getHeader(paramName);
        out.println("<h2>"+paramName+":"+header+"</h2>");
    }
%>
</body>
</html>
