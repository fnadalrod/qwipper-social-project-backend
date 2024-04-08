package com.qwipper.auth.application.service;

import com.qwipper.auth.domain.exception.InvalidPasswordException;
import com.qwipper.auth.domain.exception.UserDoesNotExistException;
import com.qwipper.auth.domain.model.User;
import com.qwipper.auth.domain.repository.AuthRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthService {

    private AuthRepository repository;

    private JwtService jwtService;

    public AuthService(AuthRepository repository, JwtService jwtService) {
        this.repository = repository;
        this.jwtService = jwtService;
    }

    public Map<String, Object> login(String username, String password) {
        Optional<User> optionalUser = repository.findByUserName(username);

        if (optionalUser.isEmpty()) {
            throw new UserDoesNotExistException();
        }

        User user = optionalUser.get();

        //TODO Password should be crypted!!!
        if (!Objects.equals(password, user.getPassword().value())) {
            throw new InvalidPasswordException();
        }

        return jwtService.generateAuthData(user);
    }
}
