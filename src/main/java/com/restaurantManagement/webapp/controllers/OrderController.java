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

    @GetMapping("/filter/{status}")
    public List<Order> getOrdersByStatus(@PathVariable("status") String statusName) {
        OrderStatusDTO orderStatusDTO = new OrderStatusDTO(statusName.toUpperCase());
        return orderService.getOrdersByStatus(orderStatusDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateOrderStatus(@PathVariable("id") Long id, @RequestBody OrderStatusDTO orderStatusDTO) {
        orderStatusDTO.setId(id);
        return orderService.updateOrderStatus(orderStatusDTO);
    }

}
