package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.models.Order;
import com.restaurantManagement.webapp.models.modelsUtility.OrderStatus;
import com.restaurantManagement.webapp.services.interfaces.OrderService;
import org.aspectj.weaver.ast.Or;
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

    @GetMapping("/{status}")
    public List<Order> getOrdersByStatus(@PathVariable String status) {
        return orderService.getOrdersByStatus(OrderStatus.valueOf(status));
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/create")
    public Order createOrder(Order order) {
        return orderService.createOrder(order);
    }

    @PostMapping("/update")
    public Order updateOrderStatus(Long id, String status) {
        return orderService.updateOrderStatus(id, OrderStatus.valueOf(status));
    }

}
