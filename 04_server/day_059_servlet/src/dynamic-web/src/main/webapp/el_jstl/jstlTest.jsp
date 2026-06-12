<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 26. 6. 11.
  Time: 오후 4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>*** 변수 설정 ***</h3>
    <c:set var="name" value="홍길동"></c:set>
    <c:set var="age" value="25"></c:set>

    내 이름은 ${name} 입니다 <br/>
    내 나이는 ${age} 입니다. <br/>
    나의 키는 ${height} 입니다.

    <h3>*** forEach ***</h3>
    <c:forEach var="i" begin="1" end="10" step="1"/>
        ${i} &emsp;
    </c:forEach>
1~10까지의 합 = ${sum}
</body>



</body>
</html>
