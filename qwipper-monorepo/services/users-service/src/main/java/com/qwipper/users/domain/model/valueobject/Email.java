package com.qwipper.users.domain.model.valueobject;

import com.fasterxml.jackson.annotation.JsonValue;

public record Email(String value) {
    public Email {}

    @Override
    @JsonValue
    public String value() {
        return value;
    }
}
