package com.restaurantManagement.webapp.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DishDTO {

    private Long id;
    private String name;
    private String description;
    private float weight;
    private float price;

}
