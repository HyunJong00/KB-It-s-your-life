<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 26. 6. 11.
  Time: 오후 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setAttribute("apple", "사과");

  response.sendRedirect("sendResult.jsp");
%>
%>
<html>
<head>
    <title>sendProc</title>
</head>
<body>

</body>
</html>
