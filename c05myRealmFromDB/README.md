# shiroStudy
关于shiro的学习
realm（安全数据用户 角色 权限）来自于数据库
    1.自定义realm类，继承AuthorizingRealm类  （Authorizing授权）
        实现doGetAuthorizationInfo和doGetAuthenticationInfo方法
    2.ini配置文件配置自定义realm
        myRealm = com.ims.shiro.realm.MyRealm
        securityManager.realms = $myRealm
    3.认证和授权流程
        subject.login(token)时，会调用doGetAuthenticationInfo方法验证身份。
        当请求有访问权限的请求时，会调用doGetAuthorizationInfo方法获取授权信息。
           
