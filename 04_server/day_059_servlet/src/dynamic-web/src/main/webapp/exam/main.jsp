<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> JSP </title>
</head>
<body>
    <h3>***include directive ***</h3>
    <%@include file="today.jsp"%>

    <h3>*** include JSP tag</h3>
    <jsp:include page="image.jsp"></jsp:include>

    <% String name = "홍길동";
    %>
    <h3>main.jsp name = <%=name%></h3>
</body>
</html>