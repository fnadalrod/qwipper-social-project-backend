package com.qwipper.users.application.find;

import com.qwipper.users.application.find.GetUsersQuery;
import com.qwipper.users.domain.model.User;
import com.qwipper.users.domain.model.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersHandler {
    private final UserRepository userRepository;

    public GetUsersHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> handle(GetUsersQuery query)  {
        return userRepository.findAll();
    }
}