<%--
  Created by gaoxu.
  User: gaoxu
  Date: 2019/5/6 0006
  Time: 17:19
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆页面</title>
</head>
<body>
<form action="login" method="post">
    <span style="color: red">${errorInfo}</span></br>
    userName:<input type="text" name="userName"/></br>
    password:<input type="password" name="password"/></br>
    <input type="submit" value="登录"/></td>
</form>
</body>
</html>