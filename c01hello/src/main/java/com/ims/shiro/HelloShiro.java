package com.ims.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @description:
 * @author: GaoXu
 * @date: 2020/4/24 21:19
 */
public class HelloShiro {

    public static void main(String[] args) {
        /**
         * 方式1，直接new DefaultSecurityManager，然后securityManager再绑定Realm。
         */
        /*DefaultSecurityManager securityManager = new DefaultSecurityManager();
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        securityManager.setRealm(iniRealm);
        SecurityUtils.setSecurityManager(securityManager);*/

        /**
         * 方式2，SecurityManagerFactory不绑定realm，获取securityManager后再绑定Realm。
         */
       /* Factory<SecurityManager> factory = new IniSecurityManagerFactory();
        DefaultSecurityManager securityManager = (DefaultSecurityManager) factory.getInstance();
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        securityManager.setRealm(iniRealm);
        SecurityUtils.setSecurityManager(securityManager);*/

        /**
         * 方式3，SecurityManagerFactory绑定Realm。
         */
        // 读取配置文件，初始化SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 获取securityManager实例
        SecurityManager securityManager = factory.getInstance();
        // 把securityManager实例绑定到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        // 得到当前执行的用户
        Subject currentUser = SecurityUtils.getSubject();
        // 创建token令牌，用户名/密码
        UsernamePasswordToken token = new UsernamePasswordToken("java1234", "12345");
        try {
            // 身份认证
            currentUser.login(token);
            System.out.println("身份认证成功！");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("身份认证失败！");
        }
        // 退出
        currentUser.logout();
    }
}
