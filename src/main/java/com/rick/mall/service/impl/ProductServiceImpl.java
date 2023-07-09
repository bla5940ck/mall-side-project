package com.rick.mall.service.impl;

import com.rick.mall.controller.input.AddProductVIn;
import com.rick.mall.controller.input.UpdateProductVIn;
import com.rick.mall.dao.IProductDao;
import com.rick.mall.model.entity.Product;
import com.rick.mall.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {

        Product productById = productDao.getProductById(productId);

        return productById;
    }

    @Override
    public Integer createProduct(AddProductVIn addProductVIn) {

        return productDao.createProduct(addProductVIn);

    }

    @Override
    public void updateProduct(Integer productId , UpdateProductVIn updateProductVIn) {

       productDao.updateProduct(productId ,updateProductVIn);
    }
}
