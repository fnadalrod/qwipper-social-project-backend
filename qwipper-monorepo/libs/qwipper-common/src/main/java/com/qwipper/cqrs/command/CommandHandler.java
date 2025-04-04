package com.qwipper.cqrs.command;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
