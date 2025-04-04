package com.qwipper.users.domain.model.valueobject;

import com.fasterxml.jackson.annotation.JsonValue;

public final class UserId {
    private final String value;

    public UserId(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}