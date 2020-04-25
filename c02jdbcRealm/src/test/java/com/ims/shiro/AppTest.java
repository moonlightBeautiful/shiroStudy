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
        //方式2，配置文件写数据源配置，只能在获得工厂的时候使用


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
