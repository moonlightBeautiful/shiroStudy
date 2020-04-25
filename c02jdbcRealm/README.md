# shiroStudy 身份认证      
1.Subject:
    简介：
        认证主体，Shiro 中最重要的概念
        任何与系统交互的“东西”都是Subject，
    Subject认证主体包含两个信息：
         Principals：身份，可以是用户名，邮件，手机号码等等，用来标识一个登录主体身份。
         Credentials：凭证，常见有密码，数字证书等等。
2.认证流程：看图 subject.login
     通俗的讲，就是在securityManager中调用authenticator从realm查找此用户。
3.jdbcRealm
    jdbcRealm设置数据源2种方式：其中表名必须是users，字段必须存在id、userName、password 
    1.在shiro.ini中配置安全数据[main]
        只能在实例化工厂的时候绑定
            Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:c3p0_realm.ini")中使用
        不可以实例化realm绑定
            NO：IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
                securityManager.setRealm(iniRealm);
    2.在代码中设置安全数据源，
        可以
            JdbcRealm realm = new JdbcRealm();
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            {
                dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/db_shiro");
                dataSource.setUser("root");
                dataSource.setPassword("root");
            }
           realm.setDataSource(dataSource);
        后，动态绑定securityManager.setRealm(realm);
            
                       
 
      
