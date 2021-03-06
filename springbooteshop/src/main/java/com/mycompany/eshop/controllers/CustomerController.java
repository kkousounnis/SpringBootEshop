package com.mycompany.eshop.controllers;

import com.mycompany.eshop.entities.Customer;
import com.mycompany.eshop.services.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private String listurl = "customer/listcustomers";
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
    public String newCustomer(ModelMap view) {
        Customer customer = new Customer();
        view.addAttribute("customer", customer);
        view.addAttribute("listurl", listurl);
        return ("newcustomer");

    }

    @PostMapping("/newcustomer")
    public String saveCustomer(ModelMap view, Customer customer) {

        if (customerService.save(customer)) {
            view.addAttribute("message", new String("Customer saved succesfully!"));
        } else {

            view.addAttribute("message", new String("Customer failed to be saved!"));
        }
        view.addAttribute("listurl", listurl);
        return ("newcustomer");

    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(ModelMap view, @PathVariable int id) {
        if (customerService.delete(id)) {
            view.addAttribute("msg", new String("Deleted Successfully!"));
        } else {
            view.addAttribute("msg", new String("Not Deleted!"));
        }
        return ("redirect:/customer/listcustomers");
    }

    @GetMapping("/edit/{id}")
    public String editCustomer(ModelMap view, @PathVariable int id) {
        Customer customer = customerService.findById(id);
        view.addAttribute("customer", customer);
        view.addAttribute("updateurl", updateurl);
        view.addAttribute("listurl", listurl);
        return ("editcustomer");
    }

    @PostMapping("/update")
    public String updateCustomer(ModelMap view, Customer customer) {
        customerService.update(customer);
        
        view.addAttribute("msg", new String(""));
        return ("redirect:/customer/listcustomers");
    }

}
