package com.rick.mall.dao.impl;

import com.rick.mall.dao.ProductDao;
import com.rick.mall.model.entity.Product;
import com.rick.mall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductImpl implements ProductDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public Product getProductById(Integer productId) {
        String sql = "SELECT product_id,product_name, category, image_url, price, stock, " +
                "description, created_date, last_modified_date from PRODUCT" +
                " WHERE product_id = :productId";

        Map<String,Object> map = new HashMap<>();
        map.put("productId",productId);


        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if(!CollectionUtils.isEmpty(productList)) {
            return productList.get(0);
        }else{
            return null;
        }

    }
}
