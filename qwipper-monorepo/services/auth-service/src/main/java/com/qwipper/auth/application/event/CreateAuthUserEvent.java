package com.qwipper.auth.application.event;

public record CreateAuthUserEvent(CreateAuthUserEventPayload payload, String context, String timestamp) {
}
