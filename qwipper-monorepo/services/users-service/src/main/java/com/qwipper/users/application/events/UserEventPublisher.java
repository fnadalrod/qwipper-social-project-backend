package com.qwipper.users.application.events;

import com.qwipper.common.messaging.publisher.EventPublisher;
import com.qwipper.users.domain.model.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

@Service
public class UserEventPublisher {

    private static final String USER_EXCHANGE = "domain.users";

    private final EventPublisher eventPublisher;

    public UserEventPublisher(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishUserCreated(User user) {
        eventPublisher.publish(
                USER_EXCHANGE,
                "user.created",
                Map.of(
                        "userId", user.getId().toString(),
                        "email", user.getEmail(),
                        "timestamp", Instant.now()
                )
        );
    }
}
