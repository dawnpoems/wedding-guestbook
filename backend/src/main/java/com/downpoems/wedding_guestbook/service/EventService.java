package com.downpoems.wedding_guestbook.service;

import com.downpoems.wedding_guestbook.entity.Event;
import com.downpoems.wedding_guestbook.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Optional<Event> findById(UUID id) {
        return eventRepository.findById(id);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public void deleteById(UUID id) {
        eventRepository.deleteById(id);
    }
}

