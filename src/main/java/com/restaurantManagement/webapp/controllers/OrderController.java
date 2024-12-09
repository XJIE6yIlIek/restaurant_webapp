package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.models.Order;
import com.restaurantManagement.webapp.models.modelsUtility.OrderStatus;
import com.restaurantManagement.webapp.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/filter")
    public List<Order> getOrdersByStatus(@RequestParam("status") String status) {
        return orderService.getOrdersByStatus(OrderStatus.valueOf(status));
    }

    @PostMapping("/create") // FIXME: CHINIT (sm postman)
    public Order createOrder(@RequestParam Order order) {
        return orderService.createOrder(order);
    }

    @PostMapping("/update/{id}")
    public Order updateOrderStatus(@PathVariable("id") Long id, @RequestBody String status) {
        return orderService.updateOrderStatus(id, OrderStatus.valueOf(status));
    }

}
