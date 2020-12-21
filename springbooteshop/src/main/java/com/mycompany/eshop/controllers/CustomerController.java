package com.mycompany.eshop.controllers;

import com.mycompany.eshop.entities.Customer;
import com.mycompany.eshop.services.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private String listurl = "list";
    private String editurl = "edit";
    private String deleteurl = "delete";
    private String updateurl = "update";

    @Autowired
    CustomerService customerService;

    @RequestMapping("/{id}")
    public String customerById(ModelMap view, @PathVariable String id) {
        Customer customer = customerService.findById(Integer.parseInt(id));
        view.addAttribute("customer", customer);
        return ("customer");
    }

    @RequestMapping("/listcustomers")
    public String listAllStudents(ModelMap view,
            @RequestParam(required = false) String msg) {
        List<Customer> customers = customerService.findAll();
        view.addAttribute("customers", customers);
        view.addAttribute("editurl", editurl);
        view.addAttribute("deleteurl", deleteurl);
        view.addAttribute("msg", msg);
        return ("listcustomers");
    }
    
    @RequestMapping("/newcustomer")
    public String newCustomer(ModelMap view){
        Customer customer = new Customer();
        view.addAttribute("customer", customer);
        view.addAttribute("listurl", listurl);
        return("newcustomer");       
    
    }

}
