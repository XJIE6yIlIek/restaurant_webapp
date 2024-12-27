package com.restaurantManagement.webapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter @Getter
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "event_time", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mmZ")
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
