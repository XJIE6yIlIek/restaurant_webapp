package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.Event;
import com.restaurantManagement.webapp.models.dtos.EventDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventService {

    ResponseEntity<Event> createEvent(EventDTO event);
    ResponseEntity<Event> updateEvent(EventDTO event);
    void deleteEvent(Long id);
    List<Event> getAllEvents();
    Event getEventById(Long id);

}
