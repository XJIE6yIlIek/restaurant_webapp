package com.restaurantManagement.webapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;
    @Column(name = "dish_id")
    private Long dishId;
    @Transient
    private String dishName;
    @Column(name = "quantity", nullable = false)
    private Long quantity;

    public OrderItem(Order order, Long dishId, Long quantity) {
        this.order = order;
        this.dishId = dishId;
        this.quantity = quantity;
    }

}
