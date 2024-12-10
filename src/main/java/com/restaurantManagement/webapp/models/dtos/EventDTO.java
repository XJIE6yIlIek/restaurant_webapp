package com.restaurantManagement.webapp.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter @Getter
public class EventDTO {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime timestamp;
    private Integer capacity;

}
