package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.models.Event;
import com.restaurantManagement.webapp.services.interfaces.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping("/create")
    public Event createEvent(Event event) {
        return eventService.createEvent(event);
    }

    @PostMapping("/update")
    public Event updateEvent(Event event) {
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/delete")
    public void deleteEvent(Long id) {
        eventService.deleteEvent(id);
    }

}
