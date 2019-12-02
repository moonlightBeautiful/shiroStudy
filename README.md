# shiroStudy
关于shiro的学习
    1.hello 
        1.简介：
            强大易用的java安全框架，提供了认证、授权、加密和会话管理功能。
            4大功能：
                1.Authentication（认证）：用户身份认证和用户权限认证。
                2.Authorization（授权）：给用户授权某个权限。
                3.Session Manager（会话管理）：用户登陆后就是一次会话，在没有退出之前,它的所有信息都在会话中。                
                4.Cryptography（加密）：保护数据的安全性,如密码加密存储到数据库,而不是明文存储。
        2.实战编码
            1.shiro.ini：realm
                [users]：用户名和密码
            2.helloShiro
        3.realm：安全数据(如用户、角色、权限)
            Shiro从realm获取安全数据(如用户、角色、权限)对Subject进行认证、授权及权限验证、会话管理。
            种类：
                jdbcRealm、txtRealm、jndiRealm等，以后用jdbcRealm
            jdbcRealm：
                [main]中指定jdbcRealm配置
                数据库名字随便取，用户表名默认为users，字段默认为userName，password。
            数据库连接池负责分配、管理和释放数据库连接：
                C3P0是一个开源的JDBC连接池   
    2.身份认证      
        1.Subject:认证主体，Shiro 中最重要的概念
            任何与系统交互的“东西”都是Subject，是指应用程序用户的特定安全的“视图”。
            一个 Shiro Subject 实例代表了一个单一应用程序用户的安全状态和操作。
            Subject 认证主体包含两个信息：
                 Principals：身份，可以是用户名，邮件，手机号码等等，用来标识一个登录主体身份。
                 Credentials：凭证，常见有密码，数字证书等等。
        2.认证流程：看图        
    3.权限认证和授权
      
