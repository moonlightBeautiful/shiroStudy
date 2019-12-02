package com.java1234.shiro;

import com.java1234.util.ShiroUtil;
import org.apache.shiro.subject.Subject;

import java.beans.PropertyVetoException;

/**
 * @author gaoxu
 * @date 2019-05-05 13:17
 * @description 身份验证类
 */

public class SubjectTest {

    public static void main(String[] args) throws PropertyVetoException {
        //正确的账号和密码
        Subject subject01 = ShiroUtil.login("java1234", "123456");
        subject01.logout();
        //不正确的账号和密码
        Subject subject02 = ShiroUtil.login("java123", "123456");
        subject02.logout();
    }

}
