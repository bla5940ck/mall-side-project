package com.rick.mall.service.impl;

import com.rick.mall.dao.ProductDao;
import com.rick.mall.model.entity.Product;
import com.rick.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {

        Product productById = productDao.getProductById(productId);

        return productById;
    }
}
