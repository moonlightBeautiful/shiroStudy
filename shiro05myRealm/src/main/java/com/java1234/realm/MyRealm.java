package com.java1234.realm;

import com.java1234.dao.UserDao;
import com.java1234.entity.User;
import com.java1234.util.DbUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.sql.Connection;

/**
 * @author gaoxu
 * @date 2019-05-13 11:14
 * @description ... 类
 */
public class MyRealm extends AuthorizingRealm {
    private UserDao userDao = new UserDao();
    private DbUtil dbUtil = new DbUtil();

    /**
     * 授权
     * 在认证身份通过后，shiro自动调用这个方法给登陆人赋予角色和权限
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String userName = (String) principalCollection.getPrimaryPrincipal();
        Connection conn = null;
        try {
            conn = dbUtil.getConn();
            authorizationInfo.setRoles(userDao.getRolesByUserName(conn, userName));
            authorizationInfo.setStringPermissions(userDao.getPermissionsByUserName(conn, userName));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeConn(conn);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return authorizationInfo;
    }

    /**
     * 认证
     * 根据传入的参数token来获取登陆人的用户名，然后查询数据库此登陆人是否存在，存在则把查询到的用户名和密码返回，验证交给shiro
     *
     * @param token
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        AuthenticationInfo authenticationInfo = null;
        String userName = (String) token.getPrincipal();
        Connection conn = null;
        try {
            conn = dbUtil.getConn();
            User user = userDao.getByUserName(conn, userName);
            if (user != null) {
                authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),
                        user.getPassword(),
                        "这个内容随便写");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeConn(conn);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return authenticationInfo;
    }
}