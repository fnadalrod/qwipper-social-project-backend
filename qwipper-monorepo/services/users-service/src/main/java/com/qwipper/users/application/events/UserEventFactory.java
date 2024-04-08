package com.qwipper.users.application.events;

import com.qwipper.users.domain.model.User;
import com.qwipper.users.domain.events.UserCreatedEvent;

public final class UserEventFactory {
    public static UserCreatedEvent createUserCreatedEvent(
            User user,
            String rawPassword
    ) {
        return new UserCreatedEvent(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                rawPassword
        );
    }

    private UserEventFactory() {
    }
}
