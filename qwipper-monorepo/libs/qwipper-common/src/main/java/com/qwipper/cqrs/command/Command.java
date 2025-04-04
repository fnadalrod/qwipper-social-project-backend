package com.qwipper.cqrs.command;

public interface Command {
    default String commandName() {
        return this.getClass().getSimpleName();
    }
}
