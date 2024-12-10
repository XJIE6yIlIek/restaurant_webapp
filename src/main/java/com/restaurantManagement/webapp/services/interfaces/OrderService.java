package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.Order;
import com.restaurantManagement.webapp.models.OrderItem;
import com.restaurantManagement.webapp.models.dtos.OrderDTO;
import com.restaurantManagement.webapp.models.modelsUtility.OrderStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    ResponseEntity<Order> createOrder(OrderDTO orderDTO);
    ResponseEntity<Order> updateOrderStatus(Long orderId, OrderStatus status);
    List<Order> getOrdersByStatus(OrderStatus status);
    List<Order> getAllOrders();
    Order getOrderById(Long id);

}
