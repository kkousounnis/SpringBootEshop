package com.mycompany.eshop.dao;

import com.mycompany.eshop.entities.Product;
import org.springframework.stereotype.Repository;

@Repository("productDao")
public class ProductDao extends AbstractDao<Integer, Product>{
    
    public Product findById(int id) {
        Product s = getByKey(id);
        if (s != null) {
            return s;
        }
        return null;
    }

}
