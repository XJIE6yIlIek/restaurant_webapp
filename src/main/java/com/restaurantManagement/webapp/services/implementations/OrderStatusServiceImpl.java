package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.OrderStatus;
import com.restaurantManagement.webapp.models.dtos.OrderStatusDTO;
import com.restaurantManagement.webapp.repositories.OrderStatusRepository;
import com.restaurantManagement.webapp.services.interfaces.OrderStatusService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ResponseEntity<OrderStatus> createStatus(OrderStatusDTO orderStatusDTO) {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setName(orderStatusDTO.getName());
        return ResponseEntity.ok(orderStatusRepository.save(orderStatus));
    }

    @Transactional
    @Override
    public ResponseEntity<OrderStatus> updateStatus(OrderStatusDTO orderStatusDTO) {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setName(orderStatusDTO.getName());
        return ResponseEntity.ok(orderStatusRepository.save(orderStatus));
    }

    @Transactional
    @Override
    public void deleteStatus(Long id) {
        orderStatusRepository.deleteById(id);
    }

}
