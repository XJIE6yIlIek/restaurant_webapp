package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.Order;
import com.restaurantManagement.webapp.models.OrderItem;
import com.restaurantManagement.webapp.models.modelsUtility.OrderStatus;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);
    Order addOrderItem(Long orderId, OrderItem orderItem);
    Order updateOrderStatus(Long orderId, OrderStatus status);
    List<Order> getOrdersByStatus(OrderStatus status);
    List<Order> getAllOrders();
    Order getOrderById(Long id);

}
