package com.qwipper.users.application.command.create;

import com.qwipper.cqrs.command.Command;

public class CreateUserCommand implements Command {
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
