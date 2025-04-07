package com.qwipper.auth.application.command;

import com.qwipper.cqrs.command.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class CreateAuthUserCommandHandler  implements CommandHandler<CreateAuthUserCommand, Void> {
    @Override
    public Void handle(CreateAuthUserCommand command) {
        System.out.println("AAAA" + command.username().toString());

        return null;
    }
}
