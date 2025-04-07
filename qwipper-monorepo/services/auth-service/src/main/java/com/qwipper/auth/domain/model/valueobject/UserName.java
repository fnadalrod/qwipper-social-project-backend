package com.qwipper.auth.domain.model.valueobject;

import com.fasterxml.jackson.annotation.JsonValue;
import com.qwipper.auth.domain.exception.EmptyUserNameException;
import com.qwipper.auth.domain.exception.InvalidUserNameException;

public record UserName(String value) {
    private static final int MAX_LENGTH = 30;

    public UserName {
        if (value == null) {
            throw new EmptyUserNameException();
        }

        if (value.isBlank()) {
            throw new EmptyUserNameException();
        }

        if (value.length() > MAX_LENGTH) {
            throw new InvalidUserNameException();
        }

    }

    @Override
    @JsonValue
    public String value() {
        return value;
    }
}