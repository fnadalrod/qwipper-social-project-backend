package com.qwipper.auth.domain.repository;

import com.qwipper.auth.domain.model.User;
import com.qwipper.auth.domain.model.valueobject.UserName;

public interface UserRepository {
    boolean findByUsername(UserName username);
    User save(User user);
}