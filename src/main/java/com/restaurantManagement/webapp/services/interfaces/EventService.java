package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.Event;
import com.restaurantManagement.webapp.models.dtos.EventDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventService {

    ResponseEntity<String> createEvent(EventDTO event);
    ResponseEntity<String> updateEvent(EventDTO event);
    void deleteEvent(Long id);
    List<Event> getAllEvents();
    Event getEventById(Long id);

}
