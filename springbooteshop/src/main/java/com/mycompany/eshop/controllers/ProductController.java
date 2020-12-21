package com.mycompany.eshop.controllers;

import com.mycompany.eshop.entities.Product;
import com.mycompany.eshop.services.ProductService;
import static java.util.Date.parse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/product"})
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/{id}")
    public String productById(ModelMap view, @PathVariable String id) {
       Product product = productService.findById(Integer.parseInt(id));
       view.addAttribute("product", product);
       return "product";
    }
}
