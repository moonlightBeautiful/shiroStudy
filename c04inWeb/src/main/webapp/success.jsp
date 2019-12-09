<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="com.ims.shiro.shiro" uri="http://com.ims.shiro.shiro.apache.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆成功</title>
</head>
<body>
<com.ims.shiro.shiro:principal></com.ims.shiro.shiro:principal>登陆成功!</br>
<com.ims.shiro.shiro:hasRole name="admin">
    欢迎有admin角色的用户！
</com.ims.shiro.shiro:hasRole><br>
<com.ims.shiro.shiro:hasPermission name="user:create">
    欢迎有user:create权限的用户！
</com.ims.shiro.shiro:hasPermission><br>
<com.ims.shiro.shiro:hasRole name="teacher">
    欢迎有teacher角色的用户！
</com.ims.shiro.shiro:hasRole><br>
<com.ims.shiro.shiro:hasPermission name="student:create">
    欢迎有student:create权限的用户！
</com.ims.shiro.shiro:hasPermission>
</body>
</html>
