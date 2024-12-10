package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.models.Order;
import com.restaurantManagement.webapp.models.dtos.OrderDTO;
import com.restaurantManagement.webapp.models.modelsUtility.OrderStatus;
import com.restaurantManagement.webapp.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        LocalDateTime dateNow = LocalDateTime.now();
        orderDTO.setTimestamp(dateNow);
        return orderService.createOrder(orderDTO);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable("id") Long id, @RequestBody String status) {
        return orderService.updateOrderStatus(id, OrderStatus.valueOf(status));
    }

}
