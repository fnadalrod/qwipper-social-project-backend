package com.qwipper.auth.infrastructure.persistence.mongodb.repository;

import com.qwipper.auth.infrastructure.persistence.mongodb.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SpringDataMongoAuthRepository
        extends MongoRepository<UserDocument, String> {
    Optional<UserDocument> findByUserName(String userName);
}
