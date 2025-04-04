package com.qwipper.users.application.create;

import com.qwipper.users.infrastructure.controller.dto.UserRequest;

public class CreateUserCommand {
    private final String name;
    private final String email;

    public CreateUserCommand(String name, String email) {
        this.name     = name;
        this.email = email;
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }
}
