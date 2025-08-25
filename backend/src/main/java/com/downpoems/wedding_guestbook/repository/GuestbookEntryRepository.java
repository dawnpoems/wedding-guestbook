package com.downpoems.wedding_guestbook.repository;

import com.downpoems.wedding_guestbook.entity.GuestbookEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface GuestbookEntryRepository extends JpaRepository<GuestbookEntry, UUID> {
    List<GuestbookEntry> findByEventIdOrderByCreatedAtDescIdDesc(UUID eventId);
}

