package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.OrderStatus;
import com.restaurantManagement.webapp.models.dtos.OrderStatusDTO;
import com.restaurantManagement.webapp.repositories.OrderStatusRepository;
import com.restaurantManagement.webapp.services.interfaces.OrderStatusService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Override
    public OrderStatus getStatusByName(String name) {
        return orderStatusRepository.findByName(name);
    }

    @Override
    public List<OrderStatus> getAllStatuses() {
        return orderStatusRepository.findAll();
    }

    @Transactional
    @Override
    public ResponseEntity<String> createStatus(OrderStatusDTO orderStatusDTO) {
        String statusName = orderStatusDTO.getName();
        OrderStatus orderStatus = new OrderStatus();
        if (Objects.isNull(orderStatusRepository.findByName(statusName))) {
            orderStatus.setName(statusName);
            orderStatusRepository.save(orderStatus);
            return ResponseEntity.ok("Order status successfully created: " + statusName);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Order status already exists: " + statusName);
        }
    }

    @Transactional
    @Override
    public ResponseEntity<String> updateStatus(OrderStatusDTO orderStatusDTO) {
        Long id = orderStatusDTO.getId();
        String statusName = orderStatusDTO.getName();
        OrderStatus orderStatus = orderStatusRepository.findById(id).orElse(null);

        if (Objects.isNull(orderStatusRepository.findByName(statusName)) && !Objects.isNull(orderStatus)) {
            orderStatus.setId(id);
            orderStatus.setName(orderStatusDTO.getName());
            orderStatusRepository.save(orderStatus);
            return ResponseEntity.ok("Order status successfully created: " + id + statusName);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Order status already exists: " + statusName +
                                                                    "\nor order status with id doesn't exist: " + id);
        }
    }

    @Transactional
    @Override
    public void deleteStatus(Long id) {
        orderStatusRepository.deleteById(id);
    }

}
