package com.restaurantManagement.webapp.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class DishDTO {

    private Long id;
    private String name;
    private String description;
    private Float weight;
    private Float price;
    private Boolean stopped;

    public DishDTO(String name, String description, Float weight, Float price) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
    }
}
