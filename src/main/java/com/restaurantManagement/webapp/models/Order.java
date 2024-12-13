package com.restaurantManagement.webapp.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter @Getter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "table_number", nullable = false)
    private String tableNumber;
    @ManyToOne
    @JoinColumn(name = "status")
    private OrderStatus status;
    @Column(name = "order_time", nullable = false)
    private LocalDateTime orderTime;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;

    public Order(String tableNumber, OrderStatus orderStatus, List<OrderItem> orderItems) {
        this.tableNumber = tableNumber;
        this.status = orderStatus;
        this.items = orderItems;
    }

    public Order() {
        this.orderTime = LocalDateTime.now();
    }

}
