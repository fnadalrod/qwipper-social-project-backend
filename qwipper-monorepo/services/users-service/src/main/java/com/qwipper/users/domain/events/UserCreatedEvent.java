package com.qwipper.users.domain.events;

import com.qwipper.common.messaging.events.DomainEvent;
import com.qwipper.users.domain.model.valueobject.Email;
import com.qwipper.users.domain.model.valueobject.UserId;
import com.qwipper.users.domain.model.valueobject.UserName;

import java.util.Optional;

public class UserCreatedEvent extends DomainEvent implements UserEvent {
    private final Optional<UserId> userId;
    private final UserName userName;
    private final Email email;
    private final String passwordHash;

    public UserCreatedEvent(Optional<UserId> userId, UserName userName, Email email, String passwordHash) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public Optional<UserId> getUserId() {
        return userId;
    }

    public Email getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public UserName getUserName() {
        return userName;
    }
}
