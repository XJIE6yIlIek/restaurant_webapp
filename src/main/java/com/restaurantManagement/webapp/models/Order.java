package com.restaurantManagement.webapp.models;


import com.restaurantManagement.webapp.models.modelsUtility.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    @Column(name = "table_number", nullable = false)
    private String number;
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus status;
    @Column(name = "order_timestamp", nullable = false)
    private LocalDateTime timestamp;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "order_items", nullable = false)
    private List<OrderItem> orderItems = new ArrayList<>();

}
