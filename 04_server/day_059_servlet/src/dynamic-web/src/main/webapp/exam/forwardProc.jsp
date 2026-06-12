<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 26. 6. 11.
  Time: 오후 3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("banana", "바나나");

    RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp");
    dispatcher.forward(request, response); // 제어권 넘기기
%>
<%--<jsp:forward page="forwardResult.jsp"></jsp:forward>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
