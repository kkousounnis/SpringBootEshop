package com.mycompany.eshop.services;

import com.mycompany.eshop.dao.ProductDao;
import com.mycompany.eshop.entities.Customer;
import com.mycompany.eshop.entities.Product;
import java.util.List;
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
    
    public List<Product> findAll(){
        return (dao.findAll());
    }
    
    public boolean save(Product product){
        boolean result = false;
        result = dao.save(product);
        return (result);
    }
    
    public boolean update (Product product){
        return (dao.update(product));
    }
    
    public boolean delete(int id){
        return (dao.delete(id));
    }

}
