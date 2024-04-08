package com.qwipper.auth.infrastructure.persistence.mongodb.repository;

import com.qwipper.auth.domain.model.valueobject.UserName;
import com.qwipper.auth.domain.repository.AuthRepository;
import com.qwipper.auth.domain.model.User;
import com.qwipper.auth.infrastructure.persistence.mongodb.document.UserDocument;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public class MongoAuthRepository implements AuthRepository {
    private final SpringDataMongoAuthRepository repository;

    public MongoAuthRepository(SpringDataMongoAuthRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        UserDocument doc = UserDocument.fromDomain(user);
        UserDocument saved = repository.save(doc);

        return saved.toDomain();
    }

    @Override
    public Optional<User> findByUserName(String username) {
        Optional<UserDocument> doc = this.repository.findByUserName(username);

        return doc.map(UserDocument::toDomain);

    }
}
