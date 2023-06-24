package com.rick.mall.rowmapper;

import com.rick.mall.constant.ProductCategoryConst;
import com.rick.mall.model.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();

        product.setProductId(rs.getInt("product_id"));
        product.setProductName(rs.getString("product_name"));
        String categoryStr = rs.getString("category");
        ProductCategoryConst productCategoryConst = ProductCategoryConst.valueOf(categoryStr);
        product.setCategory(productCategoryConst);
        product.setImageUrl(rs.getString("image_url"));
        product.setPrice(rs.getInt("price"));
        product.setDescription(rs.getString("description"));
        product.setStock(rs.getInt("stock"));
        product.setCreateDate(rs.getTimestamp("created_date"));
        product.setLastModifiedDate(rs.getTimestamp("last_modified_date"));

        return product;
    }
}
