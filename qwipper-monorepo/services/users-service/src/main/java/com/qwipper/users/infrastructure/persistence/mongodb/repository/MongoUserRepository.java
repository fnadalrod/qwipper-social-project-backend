package com.qwipper.users.infrastructure.persistence.mongodb.repository;

import com.qwipper.users.domain.model.User;
import com.qwipper.users.domain.repository.UserRepository;
import com.qwipper.users.domain.model.valueobject.UserName;
import com.qwipper.users.infrastructure.persistence.mongodb.document.UserDocument;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Primary
public class MongoUserRepository implements UserRepository {
    private final SpringDataMongoUserRepository repository;

    public MongoUserRepository(SpringDataMongoUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        UserDocument doc = UserDocument.fromDomain(user);
        UserDocument saved = repository.save(doc);

        return saved.toDomain();
    }

    @Override
    public List<User> findAll() {
        return repository.findAll()
                .stream()
                .map(UserDocument::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByUsername(UserName username) {
        Optional<UserDocument> user = repository.findByUserName(username.value());

        if (user.isEmpty()) {
            return false;
        }

        return true;
    }
}
