package com.qwipper.users.application.query.find;

import com.qwipper.cqrs.query.QueryHandler;
import com.qwipper.users.domain.model.User;
import com.qwipper.users.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersHandler implements QueryHandler<GetUsersQuery, List<User>> {
    private final UserRepository userRepository;

    public GetUsersHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetUsersQuery query)  {
        return userRepository.findAll();
    }
}