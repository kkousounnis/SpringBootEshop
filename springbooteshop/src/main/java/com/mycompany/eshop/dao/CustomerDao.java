package com.mycompany.eshop.dao;

import com.mycompany.eshop.entities.Customer;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("customerDao")
public class CustomerDao extends AbstractDao<Integer, Customer> {

    public Customer findById(int id) {
        Customer customer = getByKey(id);
        if (customer != null) {
            return customer;
        }
        return null;
    }

    public boolean save(Customer customer) {
        return (persist(customer));

    }

    public List<Customer> findAll() {
        Criteria criteria = createEntityCriteria();
        return (criteria.list());
    }

    public boolean update(Customer customer) {
        Customer tempCustomer = findById(customer.getId());
        if (tempCustomer != null) {
            tempCustomer.setFirstName(customer.getFirstName());
            tempCustomer.setLastName(customer.getLastName());
            tempCustomer.setEmail(customer.getEmail());
            tempCustomer.setTel(customer.getTel());
            return (save(tempCustomer));
        } else {
            return (false);
        }
    }

    public boolean delete(int id) {
        Customer tempCustomer = findById(id);
        if (tempCustomer != null) {
            delete(tempCustomer);
            return (true);
        }
        return (false);

    }

    public List<Customer> findByFirstLastNames(String firstName, String lastName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("firstName", firstName));
        criteria.add(Restrictions.eq("lastName", lastName));
        return (criteria.list());
    }
}
