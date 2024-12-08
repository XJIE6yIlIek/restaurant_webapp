package com.restaurantManagement.webapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter @Getter
@NoArgsConstructor
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

    public Event(String name, String description, LocalDate date, LocalTime time, Integer capacity) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.capacity = capacity;
    }

}
