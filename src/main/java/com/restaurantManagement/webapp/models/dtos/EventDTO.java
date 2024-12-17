package com.restaurantManagement.webapp.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter @Getter
@NoArgsConstructor
public class EventDTO {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime eventTime;
    private Long capacity;

    public EventDTO(String name, String description, LocalDateTime eventTime, Long capacity) {
        this.name = name;
        this.description = description;
        this.eventTime = eventTime;
        this.capacity = capacity;
    }
}
