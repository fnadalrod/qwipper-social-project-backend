package com.qwipper.users.application.command.create;

import com.qwipper.cqrs.command.CommandHandler;
import com.qwipper.users.application.events.UserEventFactory;
import com.qwipper.users.domain.model.User;
import com.qwipper.users.domain.model.events.UserCreatedEvent;
import com.qwipper.users.domain.model.ports.output.UserEventOutputPort;
import com.qwipper.users.domain.model.valueobject.Email;
import com.qwipper.users.domain.model.valueobject.UserName;

import com.qwipper.users.application.service.UserValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand, Void> {
    private final UserCreator creator;
    private final UserValidator validator;
    private final UserEventOutputPort userEventPublisher;

    public CreateUserCommandHandler(
            UserCreator creator,
            UserValidator validator,
            UserEventOutputPort userEventPublisher
    ) {
        this.creator = creator;
        this.validator = validator;
        this.userEventPublisher = userEventPublisher;
    }

    @Override
    @Transactional
    public Void handle(CreateUserCommand command)  {
        UserName userName = new UserName(command.name());
        validator.validateUniqueUsername(userName);

        Email email = new Email(command.email());
        //TODO NEED ENCODING
        String passwordHash = command.password();
        User userCreated = creator.create(userName, email);

        UserCreatedEvent userCreatedEvent = UserEventFactory.createUserCreatedEvent(userCreated, passwordHash);
        userEventPublisher.publish(userCreatedEvent);

        return null;
    }
}
