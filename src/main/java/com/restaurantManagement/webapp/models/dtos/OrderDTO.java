package com.restaurantManagement.webapp.models.dtos;

import com.restaurantManagement.webapp.models.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter @Getter
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private String tableNumber;
    private OrderStatus status;
    private LocalDateTime orderTime;
    private List<OrderItemDTO> items;

    public OrderDTO(String tableNumber, OrderStatus status, LocalDateTime orderTime, List<OrderItemDTO> items) {
        this.tableNumber = tableNumber;
        this.status = status;
        this.orderTime = orderTime;
        this.items = items;
    }

}
