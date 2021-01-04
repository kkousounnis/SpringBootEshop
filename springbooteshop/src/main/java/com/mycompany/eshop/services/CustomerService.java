package com.mycompany.eshop.services;

import com.mycompany.eshop.dao.CustomerDao;
import com.mycompany.eshop.entities.Customer;
import com.mycompany.eshop.entities.dto.CustomerDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
@Transactional
public class CustomerService {
    @Autowired
    CustomerDao dao;
    
    public Customer findById(int id){
        return (dao.findById(id));
    }
    
    public List<Customer> findAll(){
        return (dao.findAll());
    }
    
    public boolean save(Customer customer){
        boolean result = false;
        result = dao.save(customer);
        return (result);
    }
    
    public boolean update (Customer customer){
        return (dao.update(customer));
    }
    
    public boolean delete(int id){
        return (dao.delete(id));
    }
    
    public List<Customer> findByFirstLastNames(String firstName,
            String lastName) {
        return (dao.findByFirstLastNames(firstName, lastName));
    }
    
    public CustomerDTO findByIdDTO(int id) {
        Customer customer = findById(id);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setTel(customer.getTel());
        customerDTO.setEmail(customer.getEmail());
        return(customerDTO);
    }

}
