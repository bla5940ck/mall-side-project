package com.rick.mall.rowmapper;

import com.rick.mall.model.entity.Product;
import com.rick.mall.model.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();

        user.setUserId(rs.getInt("user_id"));
        user.setUserName(rs.getString("userName"));
        user.setCreateDate(rs.getDate("create_date"));
        user.setLastModifiedDate(rs.getDate("lastModifiedDate"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));

        return user;
    }
}
