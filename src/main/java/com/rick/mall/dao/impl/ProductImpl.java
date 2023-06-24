package com.rick.mall.dao.impl;

import com.rick.mall.controller.input.AddProductVIn;
import com.rick.mall.dao.ProductDao;
import com.rick.mall.model.entity.Product;
import com.rick.mall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
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

    @Override
    public Integer createProduct(AddProductVIn addProductVIn) {


        String sql = "INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date)" +
                " VALUES (:productName, :category,:imageUrl," +
                " :price, :stock, :description, :createDate, :lastModifiedDate)";

        Map<String,Object> map = new HashMap<>();

        map.put("productName",addProductVIn.getProductName());
        map.put("category",addProductVIn.getCategory().toString());
        map.put("imageUrl",addProductVIn.getImageUrl());
        map.put("price",addProductVIn.getPrice());
        map.put("stock",addProductVIn.getStock());
        map.put("description",addProductVIn.getDescription());

        Date now = new Date();
        map.put("createDate",now);
        map.put("lastModifiedDate",now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);

        int i = keyHolder.getKey().intValue();

        return i;
    }
}
