package com.restaurantManagement.webapp.models.dtos;

import com.restaurantManagement.webapp.models.OrderItem;
import com.restaurantManagement.webapp.models.modelsUtility.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter @Getter
public class OrderDTO {

    private Long id;
    private String number;
    private OrderStatus status;
    private LocalDateTime timestamp;
    private List<OrderItemDTO> orderItems;

}
