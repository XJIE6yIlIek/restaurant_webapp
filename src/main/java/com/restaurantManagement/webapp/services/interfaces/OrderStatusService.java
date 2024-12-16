package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.OrderStatus;
import com.restaurantManagement.webapp.models.dtos.OrderStatusDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderStatusService {

    OrderStatus getStatusByName(String name);
    List<OrderStatus> getAllStatuses();
    ResponseEntity<String> createStatus(OrderStatusDTO orderStatusDTO);
    ResponseEntity<String> updateStatus(OrderStatusDTO orderStatusDTO);
    void deleteStatus(Long id);

}
