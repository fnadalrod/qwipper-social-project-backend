package com.qwipper.users.infrastructure.persistence.mongodb.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.qwipper.users.domain.model.User;
import com.qwipper.users.domain.model.valueobject.*;

import java.util.UUID;

@Document(collection = "users")
public class UserDocument {
    @Id
    private String id;
    private String userName;
    private String email;

    public UserDocument() {}

    public UserDocument(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.userName = name;
        this.email = email;
    }

    public UserDocument(String id, String name, String email) {
        this.id = id;
        this.userName = name;
        this.email = email;
    }

    public static UserDocument fromDomain(User user) {
        return new UserDocument(
                user.getUsername().value(),
                user.getEmail().value()
        );
    }

    public User toDomain() {
        return new User(
                new UserId(this.id),
                new UserName(this.userName),
                new Email(this.email)
        );
    }

    public String getId() { return id; }
    public String getUserName() { return userName; }
    public String getEmail() { return email; }
}
