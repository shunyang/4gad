<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <title></title>
</head>
<body>
<form:form commandName="user" action="signin">
    <table>
        <tr>
            <td>First Name:</td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="注册"/>
            </td>
            <td>
                <input type="button" value="用户列表" onclick="javascript:location.href='userlist'">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>