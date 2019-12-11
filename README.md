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
            1.com.ims.shiro.shiro.ini：com.ims.shiro.realm
                [users]：用户名和密码
            2.helloShiro
        3.com.ims.shiro.realm：安全数据(如用户、角色、权限)
            Shiro从realm获取安全数据(如用户、角色、权限)对Subject进行认证、授权及权限验证、会话管理。
            种类：
                jdbcRealm、txtRealm、jndiRealm等，以后用jdbcRealm
            jdbcRealm：
                [main]中指定jdbcRealm配置
                数据库名字随便取，用户表名默认为users，字段默认为userName，password。
            数据库连接池负责分配、管理和释放数据库连接：
                C3P0是一个开源的JDBC连接池   
    2.认证：主要是身份认证      
        1.Subject:认证主体，Shiro 中最重要的概念
            任何与系统交互的“东西”都是Subject，是指应用程序用户的特定安全的“视图”。
            一个 Shiro Subject 实例代表了一个单一应用程序用户的安全状态和操作。
            Subject 认证主体包含两个信息：
                 Principals：身份，可以是用户名，邮件，手机号码等等，用来标识一个登录主体身份。
                 Credentials：凭证，常见有密码，数字证书等等。
        2.认证流程：看图        
    3.授权：
        1.权限认证核心要素
            简介：
                也就是访问控制，即在应用中控制谁能访问哪些资源。
            核心三要素：
                权限、角色和用户、资源。
            权限：操作资源的权利，比如访问某个页面，以及对某个模块的资源的增删改查。
            角色：权限的集合，一个角色可以包含多种权限。
            用户：在shiro中，代表访问系统的用户，即subject。
        2.授权
            1.编程式授权：在代码中判断是否有角色或者权限
                1.基于角色的访问控制
                2.基于权限的访问控制
            2.注解式授权：需要java5+
                1.@RequiresAuthentication
                2.@RequiresGuest
                3.@RequiresPermissions("account:create")
                4.@RequiresRoles("administrator")
                5.@RequiresUser
            3.jsp标签授权：
        3.授权流程图
            授权：subject.isP../hasR，通俗的讲，就是在securityManager中调用authorizer从realm查看用户有哪些角色和权限。
    4.集成web
        1.web.xml 1.2之前和之后，配置不一样，以后用1.2以后的版本
            监听器+过滤器
        2.shiro配置简介
            [main]
            # authc.loginUrl：没有身份的时候，转到的请求。如果是servlet，则走get方法
            # roles.unauthorizedUrl：没有角色的时候，转到的请求
            # authc.loginUrl：没有权限的时候，转到的请求
            authc.loginUrl = /index.jsp
            roles.unauthorizedUrl = /rolesUnauthorized.jsp
            perms.unauthorizedUrl = /permsUnauthorized.jsp
            [users]
            # 用户名=密码,角色1,角色2...
            java1234 = 123456,admin
            jack = 123,teacher
            [roles]
            # 角色=资源2:权限，资源2:权限...
            admin = user:*
            teacher = student:*
            [urls]
            # 默认对所有请求不会进行身份和权限认证。 /** = authc要放在最后，否则会使所有的配置失效
            # authc：需要身份认证通过后才能访问
            # anon：不需要身份认证通过后才能访问。
            # roles[角色]：需要验证角色通过后才能访问
            # perms["权限"]：需要验证权限通过后才能访问
            /index.jsp = anon
            /login = anon
            /admin = roles[admin]
            /teacher = roles[teacher]
            /admin = perms["student:*"]
            /** = authc             
    5.realm安全数据来自于数据库
    6.shiro特性
        1.自带加密和解密
            base64、md5（不可逆）
            应用在数据库中，就是密码存加密后的字符串
        2.web支持：集成web讲过
        3.缓存支持：realm、session的支持，自己研究
        4.并发支持：
        5.测试支持
        6.run as 支持
        7.remember me：把一些信息存到cookie里面，也就是浏览器本地，用的话从cookie中取出来
            token.setRememberMe(true)
            subject.isRemembered() 返回是否记住me
            默认cookie时间是一周，
    7.spring整合shiro
        mybatis 映射方法 当方法的返回类型是 Set<String>， mapper文件中配置resultType="String"就可以
           
