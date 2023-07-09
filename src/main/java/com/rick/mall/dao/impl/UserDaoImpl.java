package com.rick.mall.dao.impl;

import com.rick.mall.dao.IUserDao;
import com.rick.mall.model.entity.Product;
import com.rick.mall.model.entity.User;
import com.rick.mall.rowmapper.ProductRowMapper;
import com.rick.mall.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements IUserDao {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public User getUserByUserName(String userName) {

        String sql = "SELECT user_id, user_name, password, email, create_date, last_modified_date" +
                "FROM user" +
                "WHERE user_name = :userName";

        Map<String,Object> map = new HashMap<>();
        map.put("userName",userName);


        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if(!CollectionUtils.isEmpty(userList)) {
            return userList.get(0);
        }else{
            return null;
        }
    }
}
