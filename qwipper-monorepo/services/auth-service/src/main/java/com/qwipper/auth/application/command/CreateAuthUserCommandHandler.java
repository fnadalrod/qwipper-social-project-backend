package com.qwipper.auth.application.command;

import com.qwipper.auth.domain.model.User;
import com.qwipper.auth.domain.model.valueobject.Password;
import com.qwipper.auth.domain.model.valueobject.UserId;
import com.qwipper.auth.domain.model.valueobject.UserName;
import com.qwipper.auth.domain.repository.AuthRepository;
import com.qwipper.cqrs.command.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class CreateAuthUserCommandHandler  implements CommandHandler<CreateAuthUserCommand, Void> {
    public AuthRepository authRepository;

    public CreateAuthUserCommandHandler(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public Void handle(CreateAuthUserCommand command) {
        authRepository.save(new User(
                new UserId(command.id()),
                new UserName(command.username()),
                new Password(command.hashedPassword()))
        );

        return null;
    }
}
