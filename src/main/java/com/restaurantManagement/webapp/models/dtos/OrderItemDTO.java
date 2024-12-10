package com.restaurantManagement.webapp.models.dtos;

import com.restaurantManagement.webapp.models.Dish;
import com.restaurantManagement.webapp.models.Order;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class OrderItemDTO {

    private Long id;
    private OrderDTO order;
    private DishDTO dish;
    private Integer quantity;

}
