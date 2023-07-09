package com.rick.mall.service;

import com.rick.mall.model.entity.User;

public interface IUserService {

    /** 取得使用者 By userId */
    User getUserByUserName(String userName);
}
