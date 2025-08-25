package com.downpoems.wedding_guestbook.controller;

import com.downpoems.wedding_guestbook.entity.Event;
import com.downpoems.wedding_guestbook.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
	private final EventService eventService;

	@GetMapping
	public List<Event> getAllEvents() {
		return eventService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Event> getEvent(@PathVariable UUID id) {
		Optional<Event> event = eventService.findById(id);
		return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public Event createEvent(@RequestBody Event event) {
		return eventService.save(event);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable UUID id) {
		eventService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

