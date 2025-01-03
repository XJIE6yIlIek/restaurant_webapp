package com.restaurantManagement.webapp.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class OrderStatusDTO {

    private Long id;
    private String name;

    public OrderStatusDTO(String name) {
        this.name = name;
    }
}
