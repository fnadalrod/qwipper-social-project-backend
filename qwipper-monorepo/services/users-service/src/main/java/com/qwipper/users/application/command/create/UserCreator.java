package com.qwipper.users.application.command.create;

import com.qwipper.users.domain.model.User;
import com.qwipper.users.domain.model.repository.UserRepository;
import com.qwipper.users.domain.model.valueobject.Email;
import com.qwipper.users.domain.model.valueobject.UserName;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {
    private final UserRepository repository;

    public UserCreator(UserRepository repository) {
        this.repository = repository;
    }

    public void create(UserName name, Email duration) {
        User user = User.createNew(name, duration);

        repository.save(user);
    }
}
