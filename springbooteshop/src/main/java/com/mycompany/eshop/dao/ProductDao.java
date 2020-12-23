package com.mycompany.eshop.dao;

import com.mycompany.eshop.entities.Product;
import java.util.List;
import org.hibernate.Criteria;
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
    
    public boolean save(Product product) {
        boolean notSaved = (persist(product));
        if(notSaved) return false;
        return true;
    }

    public List<Product> findAll() {
        Criteria criteria = createEntityCriteria();
        return (criteria.list());
    }

    public boolean update(Product product) {
        Product tempProduct = findById(product.getId());
        if (tempProduct != null) {
            tempProduct.setName(product.getName());
            tempProduct.setPrice(product.getPrice());
            tempProduct.setQuantity(product.getQuantity());
            return (save(tempProduct));
        } else {
            return (false);
        }
    }

    public boolean delete(int id) {
        Product tempProduct = findById(id);
        if (tempProduct != null) {
            delete(tempProduct);
            return (true);
        }
        return (false);

    }

}
