package com.rick.mall.service;

import com.rick.mall.controller.input.AddProductVIn;
import com.rick.mall.controller.input.UpdateProductVIn;
import com.rick.mall.model.entity.Product;

public interface ProductService {

    /** 取得商品byId */
    Product getProductById(Integer productId);

    /** 新增商品 */
    Integer createProduct(AddProductVIn addProductVIn);

    /** 更新商品 */
    void updateProduct(Integer productId ,UpdateProductVIn updateProductVIn);
}
