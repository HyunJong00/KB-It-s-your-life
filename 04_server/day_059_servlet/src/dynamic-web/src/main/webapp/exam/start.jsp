<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 26. 6. 11.
  Time: 오후 3:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <font color="red">
    <b>
      start.jsp - sendProc.jsp - sendResult.jsp 페이지 이동합니다<br>
      sendRedirect로 이동하므로 데이터는 공유하지 않습니다<br>
      주소는 sendResult.jsp가 보인다<br>
    </b>
  </font>
  <br>

  <font color="blue">
    <b>
      start.jsp - forwardProc.jsp - forwardResult.jsp 페이지 이동합니다<br>
      forward로 이동하므로 데이터는 공유합니다<br>
      주소는 forwardProc.jsp로 보이지만 결과는 forwardResult.jsp가 나온다<br>
    </b>
  </font>
  <br>

  <input type="button" value="sendRedirect" onclick="location.href='sendProc.jsp'">
  <input type="button" value="forward" onclick="location.href='forwardProc.jsp'">
</body>
</html>
