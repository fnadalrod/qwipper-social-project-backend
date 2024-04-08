package com.qwipper.auth.domain.repository;

import com.qwipper.auth.domain.model.User;
import com.qwipper.auth.domain.model.valueobject.UserName;

import java.util.Optional;

public interface AuthRepository {
    User save(User user);
    Optional<User> findByUserName(String username);
}