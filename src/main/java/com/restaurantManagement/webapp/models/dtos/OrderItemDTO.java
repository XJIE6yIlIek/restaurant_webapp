package com.restaurantManagement.webapp.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class OrderItemDTO {

    private Long id;
    private OrderDTO order;
    private Long dishId;
    private Integer quantity;

}
