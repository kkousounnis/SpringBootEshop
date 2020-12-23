package com.mycompany.eshop.controllers;

import com.mycompany.eshop.entities.Orders;
import com.mycompany.eshop.services.OrderService;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/order"})
public class OrderController {

    @Autowired
    OrderService ordersService;

    @RequestMapping(value = {"/{id}"})
    public String showOrder(ModelMap view, @PathVariable Integer id) {
        view.addAttribute("projectName", "Grocery Store");
        Orders order = ordersService.findById(id);
        view.addAttribute("order", order);
        return ("order");
    }

    @RequestMapping("/all")
    public String showOrders(ModelMap view) {
        view.addAttribute("projectName", "Grocery Store");
        List<Orders> orders;
        orders = ordersService.findAll();
        view.addAttribute("order", orders);
        return ("order");
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(ModelMap view, @PathVariable int id) {
        System.out.println("delete id:" + id);
        String message;
        try {
            ordersService.delete(id);
        } catch (EntityNotFoundException e) {

            message = "Order with id:" + id + " was not deleted!!!";
            return ("redirect:/login?msg=" + message);
        }

        message = "Order with id:" + id + " deleted successfuly!";
        return ("redirect:/login?msg=" + message);
    }

    @GetMapping("/customer/{id}")
    public String ordersByCustomerId(ModelMap view, @PathVariable String id) {
        List<Orders> orders
                = ordersService.findByCustomerId(id);
        view.addAttribute("projectName", "Grocery Store");
        view.addAttribute("order", orders);
        return ("order");
    }

}
