package com.qwipper.auth.application.event;

public record CreateAuthUserEventPayload(String email, String id, String passwordHash, String userName) {}
