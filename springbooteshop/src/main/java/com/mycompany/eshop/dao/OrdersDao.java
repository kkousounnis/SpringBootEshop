package com.mycompany.eshop.dao;

import com.mycompany.eshop.entities.Customer;
import com.mycompany.eshop.entities.Orders;
import com.mycompany.eshop.services.CustomerService;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ordersDao")
public class OrdersDao extends AbstractDao<Integer, Orders> {

    @Autowired
    CustomerService customerService;

    public Orders findById(int id) {
        Orders o = getByKey(id);
        if (o != null) {
            return o;
        }
        return null;
    }

    public List<Orders> findAll() {
        Criteria criteria = createEntityCriteria();
        return (criteria.list());

    }

    public boolean save(Orders order) {
        return (persist(order));
    }

    public boolean update(Orders order) {
        Orders tempOrder = findById(order.getId());
        if (tempOrder != null) {
            tempOrder.setDate(order.getDate());
            tempOrder.setTotalPrice(order.getTotalPrice());
            tempOrder.setCustomersId(order.getCustomersId());
            tempOrder.setOrdersDetailsList(order.getOrdersDetailsList());
            return (save(tempOrder));
        } else {
            return (false);
        }
    }

    public boolean delete(int id) {
        Orders tempOrder = findById(id);
        if (tempOrder != null) {
            try {
                delete(tempOrder);
                return (true);
            } catch (EntityNotFoundException e) {
                return (false);
            }
        }
        return (false);
    }

    public List<Orders> findByCustomerId(String customersId) {
        Customer customer = customerService.findById(Integer.parseInt(customersId));
        System.out.println("Customer: " + customer);
        Criteria criteria = createEntityCriteria();

        criteria.add(Restrictions.eq("customersId", customer));
        return (criteria.list());
    }

}
