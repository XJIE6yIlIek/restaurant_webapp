package com.restaurantManagement.webapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "weight", nullable = false)
    private float weight;
    @Column(name = "price", nullable = false)
    private float price;

    public Dish(String name, String description, float weight, float price) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
    }
}
