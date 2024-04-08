package com.qwipper.auth.domain.model.valueobject;

import com.fasterxml.jackson.annotation.JsonValue;

public record Password(String value) {
    public Password {}

    @Override
    @JsonValue
    public String value() {
        return value;
    }
}
