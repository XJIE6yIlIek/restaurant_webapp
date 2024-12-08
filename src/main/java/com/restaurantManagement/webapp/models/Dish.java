package com.restaurantManagement.webapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@Entity
@Table(name = "menu")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Long id;
    @Column(name = "dish_name", nullable = false)
    private String name;
    @Column(name = "dish_description", nullable = false)
    private String description;
    @Column(name = "dish_weight", nullable = false)
    private float weight;
    @Column(name = "dish_price", nullable = false)
    private float price;

    public Dish(String name, String description, float weight, float price) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
    }

}
