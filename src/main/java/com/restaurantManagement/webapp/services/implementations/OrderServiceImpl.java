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
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> createOrder(OrderDTO orderDTO) {
        String statusName = "RECEIVED";
        String tableNumber = orderDTO.getTableNumber();
        Order order = new Order();
        order.setTableNumber(tableNumber);
        if (!Objects.isNull(orderStatusRepository.findByName(statusName))) {
            OrderStatus orderStatus = orderStatusRepository.findByName(statusName);
            order.setStatus(orderStatus);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Order status doesn't exist: " + statusName);
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
        orderRepository.save(order);

        return ResponseEntity.ok("Order successfully created: " + tableNumber);
    }

    @Override
    @Transactional
    public ResponseEntity<String> updateOrderStatus(OrderDTO orderDTO) {
        Long id = orderDTO.getId();
        String statusName = orderDTO.getStatus().getName();
        Order order = orderRepository.findById(id).orElse(null);
        OrderStatus orderStatus = orderStatusRepository.findByName(statusName);

        if (!Objects.isNull(order) && !Objects.isNull(orderStatus)) {
            order.setStatus(orderStatus);
            orderRepository.save(order);
            return ResponseEntity.ok("Order's status successfully updated: " + id + statusName);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Order with id doesn't exist: " + id +
                                                                    "\nor order status with name doesn't exist: " + statusName);
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
