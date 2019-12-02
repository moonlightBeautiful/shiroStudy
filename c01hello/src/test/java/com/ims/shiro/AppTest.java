package com.ims.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
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
        //1.获取realm：在realm的inn文件中获取安全数据源
       /* IniRealm iniRealm = new IniRealm("classpath:shiro.ini");*/

        //2.获取DefaultSecurityManager
        //方式1，直接new DefaultSecurityManager
        /*DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(iniRealm);
        SecurityUtils.setSecurityManager(securityManager);*/

        //方式2，使用Factory获得DefaultSecurityManager实例，也可以在实例化IniSecurityManagerFactory的时候直接指定IniRealm的ini文件
       /* Factory<SecurityManager> factory = new IniSecurityManagerFactory();
        DefaultSecurityManager securityManager = (DefaultSecurityManager) factory.getInstance();
        securityManager.setRealm(iniRealm);
        SecurityUtils.setSecurityManager(securityManager);*/

        //方式3，使用Factory直接读取ini文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
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
            System.out.println("********************");
            System.out.println(" ***身份认证失败！*** ");
            System.out.println("********************");
        } finally {
            subject.logout();
        }
    }
}
