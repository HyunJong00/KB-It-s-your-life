<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 26. 6. 18.
  Time: 오후 5:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>input</title>

</head>
<body>
<form method="get" action="http://localhost:8080/result">
  <table border="1">
    <tr>
      <td width="70" align="center">X</td>
      <td><input type="text" name="x"></td>
    </tr>
    <tr>
      <td width="70" align="center">Y</td>
      <td><input type="text" name="y"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="계산">
        <input type="reset" value="취소">
      </td>
    </tr>
  </table>
</form>
</body>
</html>
