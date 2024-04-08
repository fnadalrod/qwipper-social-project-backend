package com.qwipper.users.domain.repository;

import com.qwipper.users.domain.model.User;
import com.qwipper.users.domain.model.valueobject.UserName;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    boolean existsByUsername(UserName username);
    User save(User user);
}