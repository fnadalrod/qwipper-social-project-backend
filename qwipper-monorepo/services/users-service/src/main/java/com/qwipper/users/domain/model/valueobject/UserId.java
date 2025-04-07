package com.qwipper.users.domain.model.valueobject;

import com.fasterxml.jackson.annotation.JsonValue;

public record UserId(String value) {

    @Override
    @JsonValue
    public String value() {
        return value;
    }
}