<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 26. 6. 11.
  Time: 오후 3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String apple = request.getAttribute("apple").toString();
%>
<html>
<head>
    <title>sendResult</title>
</head>
<body>
  결과 = <%= apple %>
</body>
</html>
