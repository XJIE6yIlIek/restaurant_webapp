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
    @Column(name = "event_id")
    private Long id;
    @Column(name = "event_name", nullable = false)
    private String name;
    @Column(name = "event_description", nullable = false)
    private String description;
    @Column(name = "event_timestamp", nullable = false)
    private LocalDateTime timestamp;
    @Column(name = "event_capacity", nullable = false)
    private Integer capacity;

}
