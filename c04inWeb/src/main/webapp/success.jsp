<%--
  Created by gaoxu.
  User: gaoxu
  Date: 2019/5/6 0006
  Time: 17:45
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆成功</title>
</head>
<body>
<shiro:principal></shiro:principal>登陆成功!</br>
<shiro:hasRole name="admin">
    欢迎有admin角色的用户！
</shiro:hasRole><br>
<shiro:hasPermission name="student:create">
    欢迎有student:create权限的用户！
</shiro:hasPermission>
</body>
</html>
