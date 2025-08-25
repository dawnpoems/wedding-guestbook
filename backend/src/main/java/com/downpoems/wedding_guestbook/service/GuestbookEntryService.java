package com.downpoems.wedding_guestbook.service;

import com.downpoems.wedding_guestbook.entity.GuestbookEntry;
import com.downpoems.wedding_guestbook.repository.GuestbookEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GuestbookEntryService {
    private final GuestbookEntryRepository guestbookEntryRepository;

    public List<GuestbookEntry> findByEventId(UUID eventId) {
        return guestbookEntryRepository.findByEventIdOrderByCreatedAtDescIdDesc(eventId);
    }

    public Optional<GuestbookEntry> findById(UUID id) {
        return guestbookEntryRepository.findById(id);
    }

    public GuestbookEntry save(GuestbookEntry entry) {
        return guestbookEntryRepository.save(entry);
    }

    public void deleteById(UUID id) {
        guestbookEntryRepository.deleteById(id);
    }
}

