package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.Event;

import java.util.List;

public interface EventService {

    Event createEvent(Event event);
    Event updateEvent(Event event);
    void deleteEvent(Long id);
    List<Event> getAllEvents();
    Event getEventById(Long id);

}
