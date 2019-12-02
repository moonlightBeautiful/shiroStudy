package com.ims.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest {


    @Before
    public void setUp() throws Exception {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        DefaultSecurityManager securityManager = (DefaultSecurityManager) factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
    }

    /**
     * 是否有角色，返回boolean
     * hasRole(string)：是否有这个角色   boolean
     * hasRoles(list<string>):是否有这些角色    boolean[]
     * hasAllRoles(list<string>):是否都有这些角色    boolean
     * <p>
     * 检查是否有角色，没有返回，不通过则抛出异常
     * checkRole(string)：检查是否有这个角色，没有则直接跑出异常   void
     * checkRoles(list<string>)：如果不能同时全部有这些角色，则直接跑出异常   void
     */
    @Test
    public void testRole() {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("java1234", "1234");
        try {
            subject.login(token);
            System.out.println("************************************************************");
            System.out.println("************************身份认证成功！**********************");
            System.out.println("************************************************************");
            /**
             * 是否有角色，返回boolean
             * hasRole(string)：是否有这个角色   boolean
             * hasRoles(list<string>):是否有这些角色    boolean[]
             * hasAllRoles(list<string>):是否都有这些角色    boolean
             */
            System.out.println("************************hasRole(string)：" + subject.hasRole("role1"));
            System.out.println("************************hasRole(List<string>)：[0]" + subject.hasRoles(Arrays.asList("role1", "role2"))[0]);
            System.out.println("************************hasRole(List<string>)：[1]" + subject.hasRoles(Arrays.asList("role1", "role2"))[1]);
            System.out.println("************************hasAllRoles(list<string>)" + subject.hasAllRoles(Arrays.asList("role1", "role2")));

            /**
             * 检查是否有角色，没有返回，不通过则抛出异常
             * checkRole(string)：检查是否有这个角色，没有则直接跑出异常   void
             * checkRoles(list<string>)：如果不能同时全部有这些角色，则直接抛出异常   void
             */
            subject.checkRole("role1");
            subject.checkRoles(Arrays.asList("role1", "role2"));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("************************************************************");
            System.out.println("************************身份认证失败！**********************");
            System.out.println("************************************************************");
        } finally {
            subject.logout();
        }
    }

    /**
     * 是否拥有权限，返回booean
     * isPermitted（String）：是否有权限 boolean
     * isPermitted（String..）:是否有这些权限们    boolean[]
     * isPermittedAll(list<string>):是否权限都有 boolean
     * <p>
     * 检查权限，没有返回，不通过则抛出异常
     * checkPermission(string)：检查是否有这个权限，没有则直接跑出异常   void
     * checkPermissions(string...)：如果不能同时全部有这些权限，则直接跑出异常   void
     */
    @Test
    public void testPermission() {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("java1234", "1234");
        try {
            subject.login(token);
            System.out.println("************************************************************");
            System.out.println("************************身份认证成功！**********************");
            System.out.println("************************************************************");
            /**
             * 是否有权限，返回boolean
             * isPermitted（String）：是否有权限 boolean
             * isPermitted（String..）:是否有这些权限们    boolean[]
             * isPermittedAll(list<string>):是否权限都有 boolean
             */
            System.out.println("isPermitted(string)：" + subject.isPermitted("user:select"));
            System.out.println("isPermitted(string...)[0]：" + subject.isPermitted("user:select", "user:delete")[0]);
            System.out.println("isPermitted(string...)[1]：" + subject.isPermitted("user:select", "user:delete")[1]);
            System.out.println("isPermittedAll(string...)：" + subject.isPermittedAll("user:select", "user:delete"));

            /**
             * 检查权限，没有返回，不通过则抛出异常
             * checkPermission(string)：检查是否有这个权限，没有则直接跑出异常   void
             * checkPermissions(string...)：如果不能同时全部有这些权限，则直接跑出异常   void
             */
            subject.checkPermission("user:select");
            subject.checkPermissions("user:select", "user:delete");
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
