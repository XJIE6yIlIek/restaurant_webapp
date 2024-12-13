package com.restaurantManagement.webapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
    private Order order;
    @Column(name = "dish_id")
    private Long dishId;
    @Column(name = "quantity", nullable = false)
    private Long quantity;

    public OrderItem(Order order, Long dishId, Long quantity) {
        this.order = order;
        this.dishId = dishId;
        this.quantity = quantity;
    }

}
