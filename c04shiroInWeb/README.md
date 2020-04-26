集成web
    1.引入一大堆jar包
    2.配置web.xml和log4j
        shiro1.2之前和之后，web.xml配置不一样，以后用1.2以后的版本：监听器+过滤器
    3.shiro配置简介
        [main]
        # authc.loginUrl：没有身份的时候，转到的请求。如果是servlet，则走get方法
        # roles.unauthorizedUrl：没有角色的时候，转到的请求
        # authc.loginUrl：没有权限的时候，转到的请求
        authc.loginUrl = /login
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
        # authc：需要身份认证通过后，才能访问
        # anon：不需要进行身份认证，可以直接访问。
        # roles[角色]：需要有对应的角色才能访问
        # perms["权限"]：需要有对应的权限才能访问
        /index.jsp = anon
        /login = anon
        /admin = roles[admin]
        /teacher = roles[teacher]
        /admin = perms["student:*"]
        /** = authc          
    4.url匹配符
        ? 匹配一个字符   /admin?   =  /admin1 或者  /admin
        * 匹配0个、1个、多个字符   /admin*   =  /admin 或者  /admin1 或者 admin123
        ** 匹配多路径    /admin/**   =  /admin/1/2  或者 /admin/121  或者 /admin
    5.shiro jsp标签
        1.jsp页面引入
            <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
        2.使用shiro jsp标签
    6.shiro会话机制
        底层有容器的会话机制，默认使用servlet容器的session
        Session session = subject.getSession();
        System.out.println("sessionId:" + session.getId());
        System.out.println("sessionHost:" + session.getHost());
        System.out.println("sessionTimeout:" + session.getTimeout());       
