package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.Order;
import com.restaurantManagement.webapp.models.OrderItem;
import com.restaurantManagement.webapp.models.modelsUtility.OrderStatus;
import com.restaurantManagement.webapp.repositories.OrderItemRepository;
import com.restaurantManagement.webapp.repositories.OrderRepository;
import com.restaurantManagement.webapp.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order addOrderItem(Long orderId, OrderItem orderItem) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            orderItem.setOrder(order);
            order.getOrderItems().add(orderItem);
            orderItemRepository.save(orderItem);
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

}
