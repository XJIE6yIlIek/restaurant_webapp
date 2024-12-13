package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.models.Order;
import com.restaurantManagement.webapp.models.dtos.OrderDTO;
import com.restaurantManagement.webapp.models.OrderStatus;
import com.restaurantManagement.webapp.models.dtos.OrderStatusDTO;
import com.restaurantManagement.webapp.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
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
    public List<Order> getOrdersByStatus(@RequestParam("status") OrderStatusDTO orderStatusDTO) {
        return orderService.getOrdersByStatus(orderStatusDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable("id") Long id, @RequestBody OrderStatusDTO orderStatusDTO) {
        return orderService.updateOrderStatus(id, orderStatusDTO);
    }

}
