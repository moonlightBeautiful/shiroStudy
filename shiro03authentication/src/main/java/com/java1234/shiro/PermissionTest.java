package com.java1234.shiro;

import com.java1234.util.ShiroUtil;
import org.apache.shiro.subject.Subject;

import java.beans.PropertyVetoException;

/**
 * @author gaoxu
 * @date 2019-05-05 18:07
 * @description ... 类
 */
public class PermissionTest {
    /**
     * isPermitted（String）：是否有权限 boolean
     * isPermitted（String..）:是否有这些权限们    boolean[]
     * isPermittedAll(list<string>):是否权限都有 boolean
     */
    public static void permitted() {
        Subject subject = null;
        try {
            subject = ShiroUtil.login("java1234", "123456");
            System.out.println(subject.isPermitted("zouxuesheng"));
            System.out.println(subject.isPermitted("zouxuesheng", "zouxuesheng1")[1]);
            System.out.println(subject.isPermittedAll("zouxuesheng", "zouxuesheng"));
        } catch (PropertyVetoException e) {
            System.out.println("*权限验证失败！*");
            e.printStackTrace();
        } finally {
            subject.logout();
        }
    }

    /**
     * checkPermission(string)：检查是否有这个权限，没有则直接跑出异常   void
     * checkPermissions(string...)：如果不能同时全部有这些权限，则直接跑出异常   void
     */
    public static void checkPermitted() {
        Subject subject = null;
        try {
            subject = ShiroUtil.login("java1234", "123456");
            subject.checkPermission("all");
            subject.checkPermissions("zouxuesheng1", "zouxuesheng", "zouxuesheng");
        } catch (PropertyVetoException e) {
            System.out.println("*权限检查失败！*");
            e.printStackTrace();
        } finally {
            subject.logout();
        }
    }

    public static void main(String[] args) {
        permitted();
        checkPermitted();
    }
}
