package com.qwipper.users.domain.model.valueobject;

import com.fasterxml.jackson.annotation.JsonValue;

public class Email {
    private final String value;

    public Email(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
