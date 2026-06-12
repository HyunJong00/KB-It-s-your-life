<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%!
    String name = "hong";
    int age = 35;
%>
<%
    age++;
%>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<h3> 나의 이름은 <%=name%>이고, 나이는 <%=age%> 입니다.</h3>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br/>
<a href="http://localhost:8080/babo">Person Servlet</a>
<br/>
<a href="http://localhost:8080/add"> 덧셈</a>
</body>
</html>