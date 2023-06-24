package com.rick.mall.dao;

import com.rick.mall.controller.input.AddProductVIn;
import com.rick.mall.model.entity.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(AddProductVIn addProductVIn);


}
