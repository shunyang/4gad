<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <title></title>
</head>
<body>
<form:form action="login">
    <table>
        <tr>
            <td colspan="2">
                恭喜您, 用户${firstName}注册成功!
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="首页"/>
            </td>
            <td>
                <input type="button" value="用户列表" onclick="javascript:location.href='userlist'">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>