<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 26. 6. 11.
  Time: 오후 4:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" width="50%">
        <tr>
            <th width="50%">표현식</th>
            <th>값</th>
        </tr>
        <tr align="center">
            <td>\${25+36}</td>
            <td>${25+36}</td>
        </tr>
        <tr align="center">
            <td>\${25/36}</td>
            <td>${25/36}</td>
        </tr>
        <tr align="center">
            <td>\${25 mod 4}</td>
            <td>${25 mod 4}</td>
        </tr>
        <tr align="center">
            <td>\${25 % 4}</td>
            <td>${25 % 4}</td>
        </tr>
        <tr align="center">
            <td>\${25 > 4}</td>
            <td>${25 > 4}</td>
        </tr>
        <tr align="center">
            <td>\${header['host']}</td>
            <td>${header['host']}</td>
        </tr>
        <tr align="center">
            <td>\${header.host}</td>
            <td>${header.host}</td>
        </tr>
    </table>

</body>
</html>
