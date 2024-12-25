package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.Event;
import com.restaurantManagement.webapp.models.dtos.EventDTO;
import com.restaurantManagement.webapp.repositories.EventRepository;
import com.restaurantManagement.webapp.services.interfaces.EventService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EventServiceImpl implements EventService { // TODO: make it so some methods return responseentity as in CustomUserDetailsServiceImpl

    @Autowired
    private EventRepository eventRepository;

    @Override
    @Transactional
    public ResponseEntity<String> createEvent(EventDTO eventDTO) { // TODO: check if there is less than n events that day
        String eventName = eventDTO.getName();
        Event event = new Event();
        event.setName(eventName);
        event.setDescription(eventDTO.getDescription());
        event.setEventTime(eventDTO.getEventTime());
        event.setCapacity(eventDTO.getCapacity());
        eventRepository.save(event);
        return ResponseEntity.ok("Event successfully created: " + eventName);
    }

    @Override
    @Transactional
    public ResponseEntity<String> updateEvent(EventDTO eventDTO) {
        Long id = eventDTO.getId();
        String eventName = eventDTO.getName();
        Event event = eventRepository.findById(id).orElse(null);
        if (!Objects.isNull(event)) {
            event.setId(eventDTO.getId());
            event.setName(eventDTO.getName());
            event.setDescription(eventDTO.getDescription());
            event.setEventTime(eventDTO.getEventTime());
            event.setCapacity(eventDTO.getCapacity());
            eventRepository.save(event);
            return ResponseEntity.ok("Event successfully updated: " + id + eventName);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Event with id doesn't exist: " + id);
        }
    }

    @Override
    @Transactional
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

}
