package com.qwipper.auth.infrastructure.controller.api.dto.request;

public class LoginRequest {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
