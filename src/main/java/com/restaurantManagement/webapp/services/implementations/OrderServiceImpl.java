package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.Dish;
import com.restaurantManagement.webapp.models.Order;
import com.restaurantManagement.webapp.models.OrderItem;
import com.restaurantManagement.webapp.models.dtos.OrderDTO;
import com.restaurantManagement.webapp.models.dtos.OrderItemDTO;
import com.restaurantManagement.webapp.models.modelsUtility.OrderStatus;
import com.restaurantManagement.webapp.repositories.DishRepository;
import com.restaurantManagement.webapp.repositories.OrderItemRepository;
import com.restaurantManagement.webapp.repositories.OrderRepository;
import com.restaurantManagement.webapp.services.interfaces.OrderService;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService { // TODO: make it so some methods return responseentity as in CustomUserDetailsServiceImpl

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DishRepository dishRepository;

    @Override
    @Transactional
    public ResponseEntity<Order> createOrder(OrderDTO orderDTO) {

        Order order = new Order();
        order.setTableNumber(orderDTO.getTableNumber());
        try {
            order.setStatus(OrderStatus.valueOf(orderDTO.getStatus()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid order status: " + orderDTO.getStatus());
        }

        List<OrderItem> items = orderDTO.getOrderItems().stream()
                .map(orderItemDTO -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setDishId(orderItemDTO.getDishId());
                    orderItem.setQuantity(orderItemDTO.getQuantity());
                    orderItem.setOrder(order);
                    return orderItem;
                }).toList();

        order.setOrderItems(items);
        return ResponseEntity.ok(orderRepository.save(order));
    }

    @Override
    @Transactional
    public ResponseEntity<Order> updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus(status);
            return ResponseEntity.ok(orderRepository.save(order));
        }
        return ResponseEntity.ofNullable(null);
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
