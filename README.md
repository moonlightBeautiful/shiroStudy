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
           
