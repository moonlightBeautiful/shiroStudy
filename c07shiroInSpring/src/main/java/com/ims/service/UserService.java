package com.ims.service;

import java.util.Set;

import com.ims.entity.User;

public interface UserService {

    public User getUserByUserName(String userName);


    public Set<String> getRolesByUserName(String userName);


    public Set<String> getPermissionsByUserName(String userName);
}
