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
    public Event getEventById(@PathVariable("id") Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping("/create")
    public Event createEvent(@RequestParam Event event) {
        return eventService.createEvent(event);
    }

    @PostMapping("/update/{id}")
    public Event updateEvent(@PathVariable("id") Long id, @RequestParam Event event) {
        event.setId(id);
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvent(@PathVariable("id") Long id) {
        eventService.deleteEvent(id);
    }

}
