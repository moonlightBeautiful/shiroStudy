package com.ims.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ims.dao.UserDao;
import com.ims.entity.User;
import com.ims.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    @Override
    public Set<String> getRolesByUserName(String userName) {
        return userDao.getRolesByUserName(userName);
    }

    @Override
    public Set<String> getPermissionsByUserName(String userName) {
        return userDao.getPermissionsByUserName(userName);
    }

}
