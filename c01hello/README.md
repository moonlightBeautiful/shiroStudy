# shiroStudy  hello 
1.简介：
    强大易用的java安全框架，提供了认证、授权、加密和会话管理功能四大核心功能。
2.4大安全要素：
    1.Authentication（认证）：用户身份识别。
    2.Authorization（授权）：访问控制。
    3.Session Manager（会话管理）：用户登陆后就是一次会话，在没有退出之前,它的所有信息都在会话中。                
    4.Cryptography（加密）：保护数据的安全性,如密码加密存储到数据库,而不是明文存储。
3.实战helloShiro
    1.引入jar包    shiro-core、slf4j-api
    2.shiro.ini配置文件和log4j配置文件
    3.代码
        1.Factory<SecurityManager> factory = new IniSecurityManagerFactory("ini文件"");
        2.SecurityManager securityManager = (DefaultSecurityManager) factory.getInstance();
        3.SecurityUtils.setSecurityManager(securityManager);
        4.Subject currentUser = SecurityUtils.getSubject();
        5.UsernamePasswordToken token = new UsernamePasswordToken("java1234", "12345");
        6.currentUser.login(token);
        7.subject.logout(token);   