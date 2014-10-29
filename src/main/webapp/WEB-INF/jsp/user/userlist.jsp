<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <title>User List</title>
</head>
<body>
<form action="userlist">
    <table>
        <tr>
            <td>查询条件</td>
            <td>
                <input type="text" name="q"/>
            </td>
            <td>
                <input type="submit" value="查询"/>
            </td>
        </tr>
    </table>
</form>
<hr>
<table border="1">
    <tr>
        <td>index</td>
        <td><font>firstName</font></td>
        <td><font>lastName</font></td>
    </tr>
    <c:set var="index" value="1"/>
    <c:forEach var="u" items="${userList}">
        <tr>
            <td>${index}</td>
            <td>${u.firstName}</td>
            <td>${u.lastName}</td>
        </tr>
        <c:set var="index" value="${index+1}"/>
    </c:forEach>
</table>
<hr>
<input type="button" value="首页" onclick="javascript:location.href='login'">
</body>
</html>