package com.restaurantManagement.webapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter @Getter
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;
    @Column(name = "event_name", nullable = false)
    private String name;
    @Column(name = "event_description", nullable = false)
    private String description;
    @Column(name = "event_date", nullable = false)
    private LocalDate date;
    @Column(name = "event_time", nullable = false)
    private LocalTime time;
    @Column(name = "event_capacity", nullable = false)
    private Integer capacity;

}
