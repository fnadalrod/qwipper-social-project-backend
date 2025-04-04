package com.qwipper.users.application.create;

import com.qwipper.users.domain.model.valueobject.Email;
import com.qwipper.users.domain.model.valueobject.UserName;

import com.qwipper.users.domain.service.UserValidator;
import org.springframework.stereotype.Service;

@Service
public class CreateUserCommandHandler {
    private final UserCreator creator;
    private final UserValidator validator;

    public CreateUserCommandHandler(UserCreator creator, UserValidator validator) {
        this.creator = creator;
        this.validator = validator;
    }

    //    @Override
    public void handle(CreateUserCommand command)  {
        UserName userName = new UserName(command.name());
        validator.validateUniqueUsername(userName);

        Email email = new Email(command.email());

        creator.create(userName, email);
    }
}
