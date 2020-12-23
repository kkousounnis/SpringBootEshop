package com.mycompany.eshop.controllers;

import com.mycompany.eshop.entities.Customer;
import com.mycompany.eshop.entities.Product;
import com.mycompany.eshop.services.ProductService;
import static java.util.Date.parse;
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
@RequestMapping({"/product"})
public class ProductController {
    
    private String listurl = "product/listproducts";
    private String editurl = "edit";
    private String deleteurl = "delete";
    private String updateurl = "update";

    @Autowired
    ProductService productService;

    @RequestMapping("/{id}")
    public String productById(ModelMap view, @PathVariable String id) {
       Product product = productService.findById(Integer.parseInt(id));
       view.addAttribute("product", product);
       return ("product");
    }
    
    @RequestMapping("/listproducts")
    public String listAllStudents(ModelMap view,
            @RequestParam(required = false) String msg) {
        List<Product> products = productService.findAll();
        view.addAttribute("products", products);
        view.addAttribute("editurl", editurl);
        view.addAttribute("deleteurl", deleteurl);
        view.addAttribute("msg", msg);
        return ("listproducts");
    }
    
    @RequestMapping("/newproduct")
    public String newCustomer(ModelMap view) {
        Product product = new Product();
        view.addAttribute("product", product);
        view.addAttribute("listurl", listurl);
        return ("newproduct");

    }
    
    @PostMapping("/newproduct")
    public String saveCustomer(ModelMap view, Product product) {

        if (productService.save(product)) {
            view.addAttribute("message", new String("Product saved succesfully!"));
        } else {

            view.addAttribute("message", new String("Product failed to be saved!"));
        }
        view.addAttribute("listurl", listurl);
        return ("newproduct");

    }
    
    @GetMapping("/delete/{id}")
    public String deleteCustomer(ModelMap view, @PathVariable int id) {
        if (productService.delete(id)) {
            view.addAttribute("msg", new String("Deleted Successfully!"));
        } else {
            view.addAttribute("msg", new String("Not Deleted!"));
        }
        return ("redirect:/product/listproducts");
    }
    
    @GetMapping("/edit/{id}")
    public String editCustomer(ModelMap view, @PathVariable int id) {
        Product product = productService.findById(id);
        view.addAttribute("product", product);
        view.addAttribute("updateurl", updateurl);
        view.addAttribute("listurl", listurl);
        return ("editproduct");
    }

    @PostMapping("/update")
    public String updateCustomer(ModelMap view, Product product) {
        productService.update(product);
        
        view.addAttribute("msg", new String(""));
        return ("redirect:/product/listproducts");
    }
    
    
    
}
