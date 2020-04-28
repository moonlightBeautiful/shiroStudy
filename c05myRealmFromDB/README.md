# shiroStudy
关于shiro的学习
realm（安全数据用户 角色 权限）来自于数据库
    1.数据库创建表 用户 角色 权限
        用户（t_user）  id  userName    password    roleId[t_role.id]
        角色（t_role）  id  roleName 
        权限（t_permission）    id  permissionName  roleId[t_role.id]
    2.自定义realm类，继承AuthorizingRealm类  （Authorizing授权）
        实现
            doGetAuthenticationInfo方法   认证当前登陆用户，subject.login(token)时，调用此方法。
            doGetAuthorizationInfo方法    授权，认证当前登陆用户后调用此方法。  
    3.ini配置文件配置自定义realm
        [main]
        myRealm = com.ims.shiro.realm.MyRealm
        securityManager.realms = $myRealm
    3.认证和授权流程
        subject.login(token)时，会调用doGetAuthenticationInfo方法验证身份。
        当请求有访问权限的请求时，会调用doGetAuthorizationInfo方法获取授权信息。
           
