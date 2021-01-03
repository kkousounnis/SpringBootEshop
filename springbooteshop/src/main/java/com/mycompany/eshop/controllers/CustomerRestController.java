/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eshop.controllers;

import com.mycompany.eshop.entities.Customer;
import com.mycompany.eshop.services.CustomerService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author George.Pasparakis
 */

@RestController
@RequestMapping(value = {"/api/customer"})
public class CustomerRestController {

    @Autowired
    CustomerService customerService;
    @CrossOrigin("http://127.0.0.1:5500")
//    @RequestMapping(value = {"/{id}"})
//    public CustomerDTO showCustomer(ModelMap view, @PathVariable String id) {
//        view.addAttribute("projectName", "Grocery Store");
//        CustomerDTO customerDTO = customerService.findByIdDTO(Integer.parseInt(id));
//        return (customerDTO);
//    }
//
//    @GetMapping("/{id}/orders")
//    public CustomerOrdersDTO showCustomerOrders(ModelMap view, @PathVariable String id) {
//        view.addAttribute("projectName", "Grocery Store");
//        CustomerOrdersDTO customerOrderDTO = customerService.findOrdersByCustomerIdDTO(Integer.parseInt(id));
//        return (customerOrderDTO);
//    }
//
//    // @GetMapping("/api/customer/{id}/orders/details")
//    public CustomerOrderDetailsDTO showCustomersOrdersDetails(@PathVariable String id) {
//        CustomerOrderDetailsDTO customerOrderDetailsDTO
//                = customerService.findOrdersAndDetailsByCustomerIdDTO(Integer.parseInt(id));
//        return (customerOrderDetailsDTO);
//    }

    @RequestMapping("/all")
    public String showCustomers(ModelMap view) {
        view.addAttribute("projectName", "Grocery Store");
        List<Customer> customers;
        customers = customerService.findAll();
        view.addAttribute("customer", customers);
        return ("customer");
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity saveNewCustomer(@RequestBody Customer customer) {

        customerService.save(customer);

        return (new ResponseEntity(HttpStatus.OK));
    }

    // B1. /api/customer/{id}/update or - prefferred way
    //  B. id, {fields to be changed} e.g. {"email": "xxx@yyy.zzz"}
    @PutMapping("/{id}/update")
    public ResponseEntity saveUpdateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        Customer tempCustomer = customerService.findById(Integer.parseInt(id));
        if (customer.getFirstName() != null) {
            tempCustomer.setFirstName(customer.getFirstName());
        }
        if (customer.getLastName() != null) {
            tempCustomer.setLastName(customer.getLastName());
        }
        if (customer.getTel() != null) {
            tempCustomer.setTel(customer.getTel());
        }
        if (customer.getEmail() != null) {
            tempCustomer.setEmail(customer.getEmail());
        }
        customerService.update(tempCustomer);
        return (new ResponseEntity(HttpStatus.OK));
    }
    
    @DeleteMapping("/{id}/delete")
    public ResponseEntity deleteCustomer(@PathVariable String id) {
        Customer tempCustomer = customerService.findById(Integer.parseInt(id));
        if(tempCustomer != null) {
            customerService.delete(Integer.parseInt(id));
            return(new ResponseEntity(HttpStatus.OK));
        }
        return(new ResponseEntity(HttpStatus.NOT_FOUND));
        
    }
    

    @GetMapping("/findbynames/{firstName}/{lastName}")
    public String findByFirstLastNames(ModelMap view, @PathVariable String firstName, @PathVariable String lastName) {
        List<Customer> customers
                = customerService.findByFirstLastNames(firstName, lastName);
        // https://www.tutorialspoint.com/hibernate/hibernate_criteria_queries.htm
        view.addAttribute("customer", customers);
        return ("customer");
    }
}
