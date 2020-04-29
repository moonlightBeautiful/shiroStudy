package com.ims.dao;

import java.util.Set;

import com.ims.entity.User;

public interface UserDao {

    /**
     * 通过用户名查询用户
     *
     * @param userName
     * @return
     */
    public User getUserByUserName(String userName);

    /**
     * 通过用户名查询角色信息
     *
     * @param userName
     * @return
     */
    public Set<String> getRolesByUserName(String userName);

    /**
     * 通过用户名查询权限信息
     *
     * @param userName
     * @return
     */
    public Set<String> getPermissionsByUserName(String userName);
}
