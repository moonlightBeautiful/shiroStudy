package com.ims.shiro;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;

import java.beans.PropertyVetoException;

/**
 * @description:
 * @author: GaoXu
 * @date: 2020/4/24 22:14
 */
public class HelloJdbcRealm {

    public static void main(String[] args) throws PropertyVetoException {
        /**
         * 1.代码中配置数据源
         */
        /**
         * 1.1 阿里巴巴druid
         */
        /*JdbcRealm realm = new JdbcRealm();
        DruidDataSource dataSource = new DruidDataSource();
        {
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/db_shiro?serverTimezone=UTC");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
        }
        realm.setDataSource(dataSource);*/
        /**
         * 1.2 c3p0
         */
      /*  JdbcRealm realm = new JdbcRealm();
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db_shiro?serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        }
        realm.setDataSource(dataSource);*/
        /**
         * 开始使用realm验证
         */
        /*Factory<SecurityManager> factory = new IniSecurityManagerFactory();
        DefaultSecurityManager securityManager = (DefaultSecurityManager) factory.getInstance();
        securityManager.setRealm(realm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("java1234", "123456");
        try {
            currentUser.login(token);
            System.out.println("身份认证成功！");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("身份认证失败！");
        }
        currentUser.logout();*/


        /**
         * 2.配置文件中配置数据源
         */
        /**
         * 2.1 阿里巴巴druid
         */
        /* Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:druid_realm.ini");*/
        /**
         * 2.1 c3p0
         */
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:c3p0_realm.ini");
        DefaultSecurityManager securityManager = (DefaultSecurityManager) factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("java1234", "123456");
        try {
            currentUser.login(token);
            System.out.println("身份认证成功！");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("身份认证失败！");
        }
        currentUser.logout();
    }
}
