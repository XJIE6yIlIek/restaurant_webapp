package com.restaurantManagement.webapp.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @Column(name = "number", nullable = false)
    private String tableNumber;
    @ManyToOne
    @JoinColumn(name = "status")
    private OrderStatus status;
    @Column(name = "order_time", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mmZ")
    private LocalDateTime orderTime;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
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
