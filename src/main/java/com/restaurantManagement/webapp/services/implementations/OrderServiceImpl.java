package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.Order;
import com.restaurantManagement.webapp.models.OrderItem;
import com.restaurantManagement.webapp.models.dtos.OrderDTO;
import com.restaurantManagement.webapp.models.OrderStatus;
import com.restaurantManagement.webapp.models.dtos.OrderStatusDTO;
import com.restaurantManagement.webapp.repositories.DishRepository;
import com.restaurantManagement.webapp.repositories.OrderRepository;
import com.restaurantManagement.webapp.repositories.OrderStatusRepository;
import com.restaurantManagement.webapp.services.interfaces.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService { // TODO: make it so some methods return responseentity as in CustomUserDetailsServiceImpl

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Autowired
    private DishRepository dishRepository;

    @Override
    @Transactional
    public ResponseEntity<Order> createOrder(OrderDTO orderDTO) {

        Order order = new Order();
        order.setTableNumber(orderDTO.getTableNumber());
        try {
            OrderStatus orderStatus = orderStatusRepository.findByName(orderDTO.getStatus().getName());
            order.setStatus(orderStatus);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid order status: " + orderDTO.getStatus().getName());
        }

        List<OrderItem> items = orderDTO.getItems().stream()
                .map(orderItemDTO -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setDishId(orderItemDTO.getDishId());
                    orderItem.setQuantity(orderItemDTO.getQuantity());
                    orderItem.setOrder(order);
                    return orderItem;
                }).toList();

        order.setItems(items);
        return ResponseEntity.ok(orderRepository.save(order));
    }

    @Override
    @Transactional
    public ResponseEntity<Order> updateOrderStatus(Long orderId, OrderStatusDTO orderStatusDTO) {
        Order order = orderRepository.findById(orderId).orElse(null);
        OrderStatus orderStatus = orderStatusRepository.findByName(orderStatusDTO.getName());
        if (!Objects.isNull(order) && !Objects.isNull(orderStatus)) {
            order.setStatus(orderStatus);
            return ResponseEntity.ok(orderRepository.save(order));
        } else {
            throw new IllegalArgumentException("Either order or order status doesn't exist: " + order + "\n" + orderStatusDTO.getName());
        }
    }

    @Override
    public List<Order> getOrdersByStatus(OrderStatusDTO statusDTO) {
        OrderStatus orderStatus = orderStatusRepository.findByName(statusDTO.getName());
        return orderRepository.findByStatus(orderStatus);
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
