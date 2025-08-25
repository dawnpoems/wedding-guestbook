package com.downpoems.wedding_guestbook.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "guestbook_entry")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuestbookEntry {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(nullable = false, length = 40)
    private String nickname;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(length = 8)
    private String emoji;

    @Column(name = "is_visible", nullable = false)
    private boolean isVisible = true;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;
}

