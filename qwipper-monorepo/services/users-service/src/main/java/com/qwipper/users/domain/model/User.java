package com.qwipper.users.domain.model;

import com.qwipper.users.domain.model.valueobject.Email;
import com.qwipper.users.domain.model.valueobject.UserId;
import com.qwipper.users.domain.model.valueobject.UserName;

import java.util.Optional;

public class User {
    private final UserId id;
    private final UserName username;
    private final Email email;

    private User() {
        this.id       = null;
        this.username     = null;
        this.email = null;
    }

    public User(UserId id, UserName username, Email email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public static User createNew(UserName username, Email email) {
        return new User(null, username, email);
    }

    public static User createFromPersistence(UserId id, UserName username, Email email) {
        return new User(id, username, email);
    }

    public Optional<UserId> getId() {
        return Optional.ofNullable(id);
    }

    public UserName getUsername() {
        return username;
    }

    public Email getEmail() {
        return email;
    }
}