package com.mycompany.eshop.services;

import com.mycompany.eshop.dao.OrdersDao;
import com.mycompany.eshop.entities.Orders;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ordersService")
@Transactional
public class OrderService {
    
    @Autowired
    OrdersDao dao;

    public Orders findById(int id) {
        return dao.findById(id);
    }

    public List<Orders> findAll() {
        return (dao.findAll());
    }

    public boolean save(Orders order) {
        boolean result = false;
        result = dao.save(order);
        return (result);
    }

    public boolean update(Orders order) {
        return (dao.update(order));
    }

    public boolean delete(int id) {
        try {
            dao.delete(id);

        } catch (EntityNotFoundException e) {
            return (false);
        }
        return (true);

    }

    public List<Orders> findByCustomerId(String customersId) {
        return (dao.findByCustomerId(customersId));
    }
}
