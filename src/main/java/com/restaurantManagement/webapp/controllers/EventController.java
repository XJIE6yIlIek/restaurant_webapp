package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.models.Event;
import com.restaurantManagement.webapp.models.dtos.EventDTO;
import com.restaurantManagement.webapp.services.interfaces.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable("id") Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEvent(@RequestBody EventDTO eventDTO) {
        return eventService.createEvent(eventDTO);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateEvent(@PathVariable("id") Long id, @RequestBody EventDTO eventDTO) {
        eventDTO.setId(id);
        return eventService.updateEvent(eventDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvent(@PathVariable("id") Long id) {
        eventService.deleteEvent(id);
    }

}
