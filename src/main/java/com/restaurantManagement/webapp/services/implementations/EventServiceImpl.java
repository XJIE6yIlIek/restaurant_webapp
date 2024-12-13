package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.Event;
import com.restaurantManagement.webapp.models.dtos.EventDTO;
import com.restaurantManagement.webapp.repositories.EventRepository;
import com.restaurantManagement.webapp.services.interfaces.EventService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService { // TODO: make it so some methods return responseentity as in CustomUserDetailsServiceImpl

    @Autowired
    private EventRepository eventRepository;

    @Override
    @Transactional
    public ResponseEntity<Event> createEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setName(eventDTO.getName());
        event.setDescription(eventDTO.getDescription());
        event.setEventTime(eventDTO.getEventTime());
        event.setCapacity(event.getCapacity());
        return ResponseEntity.ok(eventRepository.save(event));
    }

    @Override
    @Transactional
    public ResponseEntity<Event> updateEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setId(eventDTO.getId());
        event.setName(eventDTO.getName());
        event.setDescription(eventDTO.getDescription());
        event.setEventTime(eventDTO.getEventTime());
        event.setCapacity(event.getCapacity());
        return ResponseEntity.ok(eventRepository.save(event));
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
