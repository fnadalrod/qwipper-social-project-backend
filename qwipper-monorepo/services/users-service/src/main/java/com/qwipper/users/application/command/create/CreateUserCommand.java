package com.qwipper.users.application.command.create;

import com.qwipper.cqrs.command.Command;

public class CreateUserCommand implements Command {
    private final String name;
    private final String email;
    private final String password;

    public CreateUserCommand(String name, String email, String password) {
        this.name     = name;
        this.email = email;
        this.password = password;
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }
}
