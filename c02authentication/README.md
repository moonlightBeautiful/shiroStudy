# shiroStudy
关于shiro的学习 
2.身份认证      
    1.Subject:认证主体，Shiro 中最重要的概念
        任何与系统交互的“东西”都是Subject，是指应用程序用户的特定安全的“视图”。
        一个 Shiro Subject 实例代表了一个单一应用程序用户的安全状态和操作。
        Subject 认证主体包含两个信息：
             Principals：身份，可以是用户名，邮件，手机号码等等，用来标识一个登录主体身份。
             Credentials：凭证，常见有密码，数字证书等等。
    2.认证流程：看图 subject.login
         通俗的讲，就是在securityManager中调用autheticator从realm查找此用户。
    3.jdbcRealm
        jdbcRealm设置数据源2种方式 
        1.在shiro.ini中配置安全数据[main]
            只能在Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:c3p0_realm.ini")中使用
            不可以IniRealm iniRealm = new IniRealm("classpath:com.ims.shiro.shiro.ini");后动态绑定securityManager.setRealm(com.ims.shiro.realm);
        2.在代码中设置安全数据源，
            可以
                JdbcRealm com.ims.shiro.realm = new JdbcRealm();
                ComboPooledDataSource dataSource = new ComboPooledDataSource();
                {
                    dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/db_shiro");
                    dataSource.setUser("root");
                    dataSource.setPassword("root");
                }
                com.ims.shiro.realm.setDataSource(dataSource);
            后，动态绑定securityManager.setRealm(com.ims.shiro.realm);
            
                       
 
      
