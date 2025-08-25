package com.downpoems.wedding_guestbook.controller;

import com.downpoems.wedding_guestbook.entity.GuestbookEntry;
import com.downpoems.wedding_guestbook.service.GuestbookEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/guestbook-entries")
@RequiredArgsConstructor
public class GuestbookEntryController {
    private final GuestbookEntryService guestbookEntryService;

    @GetMapping("/event/{eventId}")
    public List<GuestbookEntry> getEntriesByEvent(@PathVariable UUID eventId) {
        return guestbookEntryService.findByEventId(eventId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestbookEntry> getEntry(@PathVariable UUID id) {
        Optional<GuestbookEntry> entry = guestbookEntryService.findById(id);
        return entry.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public GuestbookEntry createEntry(@RequestBody GuestbookEntry entry) {
        return guestbookEntryService.save(entry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable UUID id) {
        guestbookEntryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

