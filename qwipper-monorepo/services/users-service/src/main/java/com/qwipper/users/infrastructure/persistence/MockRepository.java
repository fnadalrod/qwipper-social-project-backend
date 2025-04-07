package com.qwipper.users.infrastructure.persistence;

import com.qwipper.users.domain.model.User;
import com.qwipper.users.domain.model.repository.UserRepository;
import com.qwipper.users.domain.model.valueobject.Email;
import com.qwipper.users.domain.model.valueobject.UserId;
import com.qwipper.users.domain.model.valueobject.UserName;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("test")
public class MockRepository implements UserRepository {
    @Override
    public List<User> findAll() {
        ArrayList list = new ArrayList();
        list.add(User.createNew(new UserName( "userName"), new Email("user@user.es")));
        return list;
    }

    @Override
    public boolean existsByUsername(UserName username) {
        return false;
    }

    @Override
    public User save(User user) {
        return user;
    }
}
