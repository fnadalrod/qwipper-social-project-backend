package com.qwipper.auth.domain.model;

import com.qwipper.auth.domain.model.valueobject.Password;
import com.qwipper.auth.domain.model.valueobject.UserId;
import com.qwipper.auth.domain.model.valueobject.UserName;

public class User {
    private final UserId id;
    private final UserName username;
    private final Password password;

    private User() {
        this.id       = null;
        this.username     = null;
        this.password = null;
    }

    public User(UserId id, UserName username, Password password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserId getId() {
        return id;
    }

    public UserName getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }
}