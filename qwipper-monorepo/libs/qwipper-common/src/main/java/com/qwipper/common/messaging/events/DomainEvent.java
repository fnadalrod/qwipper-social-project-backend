package com.qwipper.common.messaging.events;

import java.time.Instant;
import java.util.UUID;

public abstract class DomainEvent {
    private final String eventId = UUID.randomUUID().toString();
    private final Instant occurredOn = Instant.now();

    public String getEventId() {
        return eventId;
    }

    public Instant getOccurredOn() {
        return occurredOn;
    }
}
