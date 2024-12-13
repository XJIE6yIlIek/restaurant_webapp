package com.restaurantManagement.webapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter @Getter
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event { // FIXME: change table events in database a bit...(instead of time and date - timestamp)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "event_time", nullable = false)
    private LocalDateTime eventTime;
    @Column(name = "capacity", nullable = false)
    private Long capacity;

    public Event(String name, String description, LocalDateTime eventTime, Long capacity) {
        this.name = name;
        this.description = description;
        this.eventTime = eventTime;
        this.capacity = capacity;
    }



}
