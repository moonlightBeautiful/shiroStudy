package com.java1234.shiro;

import com.java1234.util.ShiroUtil;
import org.apache.shiro.subject.Subject;

import java.beans.PropertyVetoException;
import java.util.Arrays;

/**
 * @author gaoxu
 * @date 2019-05-05 17:56
 * @description ... 类
 */
public class RoleTest {
    /**
     * hasRole(string)：是否有这个角色   boolean
     * hasRoles(list<string>):是否有这些角色    boolean[]
     * hasAllRoles(list<string>):是否都有这些角色    boolean
     */
    public static void hasRole() {
        Subject subject = null;
        try {
            subject = ShiroUtil.login("java1234", "123456");
            System.out.println("角色认证[hasRole(string)],boolean：" + subject.hasRole("teacher"));
            System.out.println("角色认证[hasRole(string)],boolean[]：" + subject.hasRoles(Arrays.asList("teacher", "system"))[0]);
            System.out.println("角色认证[hasAllRoles(list<string>)],boolean：" + subject.hasAllRoles(Arrays.asList("teacher",
                    "system")));
        } catch (PropertyVetoException e) {
            System.out.println("*角色验证失败！*");
            e.printStackTrace();
        } finally {
            subject.logout();
        }
    }

    /**
     * checkRole(string)：检查是否有这个角色，没有则直接跑出异常   void
     * checkRoles(list<string>)：如果不能同时全部有这些角色，则直接跑出异常   void
     */
    public static void checkRole() {
        Subject subject = null;
        try {
            subject = ShiroUtil.login("java1234", "123456");
            subject.checkRole("teacher");
            subject.checkRoles(Arrays.asList("teacher", "student"));
        } catch (PropertyVetoException e) {
            System.out.println("*角色检查失败！*");
            e.printStackTrace();
        } finally {
            subject.logout();
        }
    }

    public static void main(String[] args) {
        hasRole();
        checkRole();
    }
}
