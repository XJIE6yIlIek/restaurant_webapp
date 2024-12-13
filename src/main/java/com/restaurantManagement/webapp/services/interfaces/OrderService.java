package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.Order;
import com.restaurantManagement.webapp.models.dtos.OrderDTO;
import com.restaurantManagement.webapp.models.OrderStatus;
import com.restaurantManagement.webapp.models.dtos.OrderStatusDTO;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    ResponseEntity<Order> createOrder(OrderDTO orderDTO);
    ResponseEntity<Order> updateOrderStatus(Long orderId, OrderStatusDTO orderStatusDTO);
    List<Order> getOrdersByStatus(OrderStatusDTO statusDTO);
    List<Order> getAllOrders();
    Order getOrderById(Long id);

}
