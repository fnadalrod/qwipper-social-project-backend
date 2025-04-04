package com.qwipper.users.infrastructure.persistence.mongodb.repository;

import com.qwipper.users.infrastructure.persistence.mongodb.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SpringDataMongoUserRepository
        extends MongoRepository<UserDocument, String> {
    Optional<UserDocument> findByUserName(String userName);
}
