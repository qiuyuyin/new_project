<%@page contentType="text/html;charset=UTF-8" language="java"
        pageEncoding="UTF-8" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h2>
    当前在线人数为：<%=application.getAttribute("count")%>
</h2>
<a href="<%=response.encodeURL("logout.jsp")%>">退出登录</a>
</body>
</html>