package com.mycompany.eshop.services;

import com.mycompany.eshop.dao.ProductDao;
import com.mycompany.eshop.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("productService")
@Transactional
public class ProductService {
    @Autowired
    ProductDao dao;

    public Product findById(int id) {
        return dao.findById(id);
    }

}
