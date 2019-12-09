package com.ims.shiro;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {


    @Before
    public void setUp() throws Exception {
        //方式1，代码中写数据源配置
       /*JdbcRealm com.ims.shiro.realm = new JdbcRealm();
        DruidDataSource dataSource = new DruidDataSource();
        {
            dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/db_shiro");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
        }
        com.ims.shiro.realm.setDataSource(dataSource);*/
        /*JdbcRealm com.ims.shiro.realm = new JdbcRealm();
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        {
            dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/db_shiro");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        }
        com.ims.shiro.realm.setDataSource(dataSource);*/
        /*DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(com.ims.shiro.realm);
        SecurityUtils.setSecurityManager(securityManager);*/
        /*Factory<SecurityManager> factory = new IniSecurityManagerFactory();
        DefaultSecurityManager securityManager = (DefaultSecurityManager) factory.getInstance();
        securityManager.setRealm(com.ims.shiro.realm);
        SecurityUtils.setSecurityManager(securityManager);*/

        //方式2，配置文件写数据源配置，只能在获得工厂的时候使用
      /*  Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:c3p0_realm.ini");*/
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:druid_realm.ini");
        DefaultSecurityManager securityManager = (DefaultSecurityManager) factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
    }

    @Test
    public void hello() {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("java1234", "1234");
        try {
            subject.login(token);
            System.out.println("************************************************************");
            System.out.println("************************身份认证成功！**********************");
            System.out.println("************************************************************");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("************************************************************");
            System.out.println("************************身份认证失败！**********************");
            System.out.println("************************************************************");
        } finally {
            subject.logout();
        }
    }
}
