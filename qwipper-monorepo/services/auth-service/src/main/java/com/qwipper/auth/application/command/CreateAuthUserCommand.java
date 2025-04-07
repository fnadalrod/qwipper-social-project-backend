package com.qwipper.auth.application.command;

import com.qwipper.cqrs.command.Command;

public record CreateAuthUserCommand(String id, String username, String hashedPassword) implements Command {
}
