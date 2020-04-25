package com.ims.shiro;

import com.ims.util.ShiroUtil;
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
public class RoleAppTest {


    /**
     * 是否有角色，返回boolean
     * hasRole(string)：是否有这个角色   boolean
     * hasRoles(list<string>):是否有这些角色    boolean[]
     * hasAllRoles(list<string>):是否都有这些角色    boolean
     */
    @Test
    public void testHasRole() {
        Subject currentUser = ShiroUtil.login("classpath:shiro_permission.ini", "java1234", "1234");

        //hasRole(string)
/*
        System.out.println(currentUser.hasRole("role1") ? "有role1这个角色" : "没有role1这个角色");
*/
        //hasRoles(list<string>)
        boolean[] results = currentUser.hasRoles(Arrays.asList("role1", "role2", "role3"));
        System.out.println(results[0] ? "有role1这个角色" : "没有role1这个角色");
        System.out.println(results[1] ? "有role2这个角色" : "没有role2这个角色");
        System.out.println(results[2] ? "有role3这个角色" : "没有role3这个角色");
        //hasAllRoles(list<string>)
/*
        System.out.println(currentUser.hasAllRoles(Arrays.asList("role1", "role2")) ? "role1,role2这两个角色都有" : "role1,role2这个两个角色不全有");
*/

        currentUser.logout();
    }

    /**
     * 检查是否有角色，没有返回，不通过则抛出异常
     * checkRole(string)：检查是否有这个角色，没有则直接跑出异常   void
     * checkRoles(list<string>)：如果不能同时全部有这些角色，则直接跑出异常   void
     * checkRoles(string...)：如果不能同时全部有这些角色，则直接跑出异常   void
     */
    @Test
    public void testCheckRole() {
        Subject currentUser = ShiroUtil.login("classpath:shiro_permission.ini", "java1234", "123456");

        currentUser.checkRole("role1");
        currentUser.checkRoles(Arrays.asList("role1", "role2"));
        currentUser.checkRoles("role1", "role2", "role3");

        currentUser.logout();
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
