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
            helloShiro
                1.com.ims.shiro.realm：安全数据
                    安全数据来源：1.从文本文件获取安全数据   2.从数据库获取安全数据 
                    1.从文本文件获取安全数据
                        1.com.ims.shiro.shiro.ini文件中写安全数据[users]
                        2.IniRealm iniRealm = new IniRealm("classpath:com.ims.shiro.shiro.ini"); 
                    2.从数据库获取安全数据 
                        使用jdbcRealm
                        1.com.ims.shiro.shiro.ini文件中写安全数据源[main]
                             Factory<SecurityManager> factory = new IniSecurityManagerFactory("ini文件"");
                             note：
                                IniRealm iniRealm = new IniRealm("classpath:com.ims.shiro.shiro.ini");
                                securityManager.setRealm(com.ims.shiro.realm);  这种方式不能设置jdbcRealm
                        2.代码中设置数据源
                            //1.设置数据源
                            DruidDataSource druidDataSource = new DruidDataSource();
                            druidDataSource.setUrl("jdbc:mysql://localhost:3306/db_shiro");
                            druidDataSource.setUsername("root");
                            druidDataSource.setPassword("root");
                            druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");                
                            //2.设置JdbcRealm
                            JdbcRealm com.ims.shiro.realm = new JdbcRealm();
                            //jdbcRealm设置数据源
                            com.ims.shiro.realm.setDataSource(druidDataSource);
                2.securityManager                                               
                    有2种方式获得，
                    直接 new DefaultSecurityManager 
                         DefaultSecurityManager securityManager = new DefaultSecurityManager();
                         或者
                    工厂Factory获得DefaultSecurityManager的实例
                         Factory<SecurityManager> factory = new IniSecurityManagerFactory();
                         DefaultSecurityManager securityManager = (DefaultSecurityManager) factory.getInstance();
                3.securityManager设置安全数据来源realm
                    securityManager.setRealm(com.ims.shiro.realm);
                4.SecurityUtils.setSecurityManager(securityManager);
                5.Subject subject = SecurityUtils.getSubject();
                6.UsernamePasswordToken token = new UsernamePasswordToken("java1234", "1234");
                7.身份认证，开启会话
                    subject.login(token);
                8.退出身份，结束会话
                    subject.logout(token);