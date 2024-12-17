package com.restaurantManagement.webapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

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
    @Column(name = "quantity", nullable = false)
    private Long quantity;

    public OrderItem(Order order, Long dishId, Long quantity) {
        this.order = order;
        this.dishId = dishId;
        this.quantity = quantity;
    }

}
