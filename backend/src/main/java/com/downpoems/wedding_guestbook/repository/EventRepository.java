package com.downpoems.wedding_guestbook.repository;

import com.downpoems.wedding_guestbook.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}

