package com.qwipper.auth.infrastructure.persistence.mongodb.document;

import com.qwipper.auth.domain.model.User;
import com.qwipper.auth.domain.model.valueobject.Password;
import com.qwipper.auth.domain.model.valueobject.UserId;
import com.qwipper.auth.domain.model.valueobject.UserName;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserDocument {
    @Id
    private final String id;
    private final String userName;
    private final String password;

    public UserDocument(String id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public static UserDocument fromDomain(User user) {
        return new UserDocument(
                user.getId().value(),
                user.getUsername().value(),
                user.getPassword().value()
        );
    }

    public User toDomain() {
        return new User(
                new UserId(this.id),
                new UserName(this.userName),
                new Password(this.password)
        );
    }

    public String getId() { return id; }
    public String getUserName() { return userName; }
    public String getPassword() { return password; }
}
