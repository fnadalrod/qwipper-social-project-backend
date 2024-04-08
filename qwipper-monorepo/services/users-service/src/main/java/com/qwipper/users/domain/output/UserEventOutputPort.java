package com.qwipper.users.domain.output;

import com.qwipper.users.domain.events.UserCreatedEvent;

public interface UserEventOutputPort {
    void publish(UserCreatedEvent event);
}
