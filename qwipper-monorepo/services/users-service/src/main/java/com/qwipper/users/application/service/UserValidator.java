package com.qwipper.users.application.service;

import com.qwipper.users.domain.exception.ExistsUserNameException;
import com.qwipper.users.domain.repository.UserRepository;
import com.qwipper.users.domain.model.valueobject.UserName;

import org.springframework.stereotype.Service;

@Service
public class UserValidator {
    private final UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateUniqueUsername(UserName username) {
        if (userRepository.existsByUsername(username)) {
            throw new ExistsUserNameException();
        }
    }
}
