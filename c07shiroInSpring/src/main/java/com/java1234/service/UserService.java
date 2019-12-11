package com.java1234.service;

import java.util.Set;

import com.java1234.entity.User;

public interface UserService {

    public User getByUserName(String userName);


    public Set<String> getRoles(String userName);


    public Set<String> getPermissions(String userName);
}
