package com.restaurantManagement.webapp.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class OrderItemDTO {

    private Long id;
    private OrderDTO order;
    private Long dishId;
    private Long quantity;

    public OrderItemDTO(OrderDTO order, Long dishId, Long quantity) {
        this.order = order;
        this.dishId = dishId;
        this.quantity = quantity;
    }

}
