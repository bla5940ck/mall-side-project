package com.rick.mall.dao;

import com.rick.mall.model.entity.User;

public interface IUserDao {

    User getUserByUserName(String userId);
}
