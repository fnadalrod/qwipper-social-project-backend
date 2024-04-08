package com.qwipper.users.domain.model;

import com.qwipper.users.domain.model.valueobject.Email;
import com.qwipper.users.domain.model.valueobject.UserId;
import com.qwipper.users.domain.model.valueobject.UserName;

import java.util.Optional;

public class User {
    private final UserId id;
    private final UserName username;
    private final Email email;
    private int userFollowingCount;
    private int userFollowedCount;

    public User(UserId id, UserName username, Email email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.userFollowingCount = 0;
        this.userFollowedCount = 0;
    }

    public static User createNew(UserName username, Email email) {
        User user = new User(null, username, email);
        user.userFollowingCount = 0;
        user.userFollowedCount = 0;

        return user;
    }

    public Optional<UserId> getId() {
        return Optional.ofNullable(id);
    }

    public UserName getUsername() {
        return username;
    }

    public Email getEmail() {
        return email;
    }

    public void addFollowingUser() {
        this.userFollowingCount++;
    }

    public void addFollowedUser() {
        this.userFollowedCount++;
    }

    public void removeFollowingUser() {
        if (this.userFollowingCount <= 0) {
            throw new IllegalStateException("Cannot have negative following count");
        }

        this.userFollowingCount--;
    }

    public void removeFollowedUser() {
        if (this.userFollowingCount <= 0) {
            throw new IllegalStateException("Cannot have negative followed count");
        }

        this.userFollowedCount--;
    }

    public int getUserFollowingCount() {
        return userFollowingCount;
    }

    public int getUserFollowedCount() {
        return userFollowedCount;
    }
}