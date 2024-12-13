package com.restaurantManagement.webapp.models.dtos;

import com.restaurantManagement.webapp.models.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter @Getter
public class OrderDTO {

    private Long id;
    private String tableNumber;
    private OrderStatus status;
    private LocalDateTime orderTime;
    private List<OrderItemDTO> items;

}
