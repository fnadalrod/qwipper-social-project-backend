package com.qwipper.users.domain.service;

import com.qwipper.users.domain.model.exception.ExistsUserNameException;
import com.qwipper.users.domain.model.repository.UserRepository;
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
