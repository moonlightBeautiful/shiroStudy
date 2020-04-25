package com.ims.shiro;

import com.ims.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class PermissionAppTest {


    /**
     * 是否拥有权限，返回booean
     * isPermitted（String）：是否有权限 boolean
     * isPermitted（String... | list<string>）:是否有这些权限们    boolean[]
     * isPermittedAll(list<string>):是否权限都有 boolean
     */
    @Test
    public void testIsPermitted() {
        Subject currentUser = ShiroUtil.login("classpath:shiro_permission.ini", "java1234", "123456");

        //是否有权限 boolean
        System.out.println("isPermitted(string)：" + currentUser.isPermitted("user:select"));
        //是否有这些权限们    boolean[]
       /* boolean[] results = currentUser.hasRoles(Arrays.asList("role1", "role2", "role3"));
        System.out.println(results[0] ? "有role1这个角色" : "没有role1这个角色");
        System.out.println(results[1] ? "有role2这个角色" : "没有role2这个角色");
        System.out.println(results[2] ? "有role3这个角色" : "没有role3这个角色");*/
        //是否全部有权限 boolean
        /*System.out.println("isPermittedAll(string...)：" + currentUser.isPermittedAll("user:select", "user:delete"));*/

        currentUser.logout();
    }

    /**
     * 检查权限，没有返回，不通过则抛出异常
     * checkPermission(string)：检查是否有这个权限，没有则直接跑出异常   void
     * checkPermissions(string... | list<string>)：如果不能同时全部有这些权限，则直接跑出异常   void
     */
    @Test
    public void testCheckPermission() {
        Subject currentUser = ShiroUtil.login("classpath:shiro_permission.ini", "java1234", "123456");

        //检查是否有这个权限，没有则直接跑出异常
        currentUser.checkPermission("user:select");
        //如果不能同时全部有这些权限，则直接跑出异常
        currentUser.checkPermissions("user:select", "user:update", "user:delete");

        currentUser.logout();
    }
}
