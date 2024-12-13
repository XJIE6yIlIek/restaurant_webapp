package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.OrderStatus;
import com.restaurantManagement.webapp.models.dtos.OrderStatusDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderStatusService {

    OrderStatus getStatusByName(String name);
    List<OrderStatus> getAllStatuses();
    ResponseEntity<OrderStatus> createStatus(OrderStatusDTO orderStatusDTO);
    ResponseEntity<OrderStatus> updateStatus(OrderStatusDTO orderStatusDTO);
    void deleteStatus(Long id);

}
