package com.rick.mall.dao;

import com.rick.mall.controller.input.AddProductVIn;
import com.rick.mall.controller.input.UpdateProductVIn;
import com.rick.mall.model.entity.Product;

public interface IProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(AddProductVIn addProductVIn);

    void updateProduct(Integer productId , UpdateProductVIn updateProductVIn);



}
