package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.Order;
import com.restaurantManagement.webapp.models.dtos.OrderDTO;
import com.restaurantManagement.webapp.models.dtos.OrderStatusDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    ResponseEntity<String> createOrder(OrderDTO orderDTO);
    ResponseEntity<String> updateOrderStatus(OrderDTO orderDTO);
    List<Order> getOrdersByStatus(OrderStatusDTO statusDTO);
    List<Order> getAllOrders();
    Order getOrderById(Long id);

}
