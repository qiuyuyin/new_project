<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>登录</h1>

<form action="${pageContext.request.contextPath}/servlet/login" method="post">
    <label>
        <input type="text" name="username">
    </label>
    <input type="submit">
</form>

</body>
</html>
