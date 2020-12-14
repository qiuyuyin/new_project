<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
    <%
        session.invalidate();
    %>
    <h3>您已退出本系统</h3>
</body>
</html>
