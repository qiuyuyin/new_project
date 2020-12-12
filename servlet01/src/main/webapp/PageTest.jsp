<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    int a,b,c;
    Date date =new Date();
%>
<%
    a=b=c=1;
    out.println(a+b+c);
    out.println(date);
%>
<hr>
<p>
    Today's date:<%= date.toLocaleString()%>
</p>
<%
    pageContext.setAttribute("name1","a");
    request.setAttribute("name2","b");
    session.setAttribute("name3","c");
    application.setAttribute("name4","d");
%>

<%
    Object name1 = pageContext.getAttribute("name1");
    Object name2 = pageContext.getAttribute("name2");
    Object name3 = pageContext.getAttribute("name3");
    Object name4 = pageContext.getAttribute("name4");
%>

<h1>value:</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
</body>
</html>
