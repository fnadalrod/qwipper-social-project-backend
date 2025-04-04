package com.qwipper.users.application.command.create;

import com.qwipper.cqrs.command.CommandHandler;
import com.qwipper.users.domain.model.valueobject.Email;
import com.qwipper.users.domain.model.valueobject.UserName;

import com.qwipper.users.domain.service.UserValidator;
import org.springframework.stereotype.Service;

@Service
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand, Void> {
    private final UserCreator creator;
    private final UserValidator validator;

    public CreateUserCommandHandler(UserCreator creator, UserValidator validator) {
        this.creator = creator;
        this.validator = validator;
    }

    @Override
    public Void handle(CreateUserCommand command)  {
        UserName userName = new UserName(command.name());
        validator.validateUniqueUsername(userName);

        Email email = new Email(command.email());

        creator.create(userName, email);

        return null;
    }
}
