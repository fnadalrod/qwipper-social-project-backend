package com.qwipper.users.domain.model.ports.output;

import com.qwipper.users.domain.model.events.UserCreatedEvent;

public interface UserEventOutputPort {
    void publish(UserCreatedEvent event);
}
