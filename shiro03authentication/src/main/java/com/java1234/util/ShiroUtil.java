package com.java1234.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;

import java.beans.PropertyVetoException;

/**
 * @author gaoxu
 * @company 北山小旭网络科技有限公司
 * @create 2019-04-15-9:49 PM
 */
public class ShiroUtil {

    public static Subject login(String userName, String password) throws PropertyVetoException {
        //1.设置数据源
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/db_shiro");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");

        //2.设置JdbcRealm
        JdbcRealm jdbcRealm = new JdbcRealm();
        //jdbcRealm设置数据源
        jdbcRealm.setDataSource(druidDataSource);
        //要开启权限查询，可以查询权限表，
        jdbcRealm.setPermissionsLookupEnabled(true);

        //3.设置DefaultSecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //defaultSecurityManager绑定jdbcRealm
        defaultSecurityManager.setRealm(jdbcRealm);

        //4.设置SecurityUtils
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //5.设置Subject
        Subject subject = SecurityUtils.getSubject();

        //6.设置UsernamePasswordToken，用户名/密码
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        try {
            //7. 身份认证
            subject.login(token);
            System.out.println("***************");
            System.out.println(" *身份认证成功！* ");
            System.out.println("***************");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("***************");
            System.out.println(" *身份认证失败！* ");
            System.out.println("***************");
        } finally {
            return subject;
        }
    }

}
