package com.java1234.dao;

import com.java1234.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @author gaoxu
 * @date 2019-05-13 14:07
 * @description ... 类
 */
public class UserDao {

    public User getByUserName(Connection conn, String userName) throws Exception {
        User resultUser = null;
        String sql = "select * from t_user where userName=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userName);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            resultUser = new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setUserName(rs.getString("userName"));
            resultUser.setPassword(rs.getString("password"));
        }
        return resultUser;
    }

    public Set<String> getRolesByUserName(Connection conn, String userName) throws Exception {
        Set<String> resultRoles = new HashSet<String>();
        String sql = "select * from t_user u,t_role r where u.roleId=r.id and u.userName=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userName);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            resultRoles.add(rs.getString("roleName"));
        }
        return resultRoles;
    }

    public Set<String> getPermissionsByUserName(Connection conn, String userName) throws Exception {
        Set<String> resultPermissions = new HashSet<String>();
        String sql = "select * from t_user u,t_role r,t_permission p where u.roleId=r.id and p.roleId=r.id and u.userName=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userName);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            resultPermissions.add(rs.getString("permissionName"));
        }
        return resultPermissions;
    }
}
