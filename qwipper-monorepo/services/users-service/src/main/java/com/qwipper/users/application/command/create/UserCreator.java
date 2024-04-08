package com.qwipper.users.application.command.create;

import com.qwipper.users.domain.model.User;
import com.qwipper.users.domain.repository.UserRepository;
import com.qwipper.users.domain.model.valueobject.Email;
import com.qwipper.users.domain.model.valueobject.UserName;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {
    private final UserRepository repository;

    public UserCreator(UserRepository repository) {
        this.repository = repository;
    }

    public User create(UserName name, Email email) {
        User user = User.createNew(name, email);

        return repository.save(user);
    }
}
