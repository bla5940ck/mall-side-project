package com.rick.mall.service.impl;

import com.rick.mall.dao.IUserDao;
import com.rick.mall.model.entity.User;
import com.rick.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private IUserDao userDao;

    @Override
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }
}
