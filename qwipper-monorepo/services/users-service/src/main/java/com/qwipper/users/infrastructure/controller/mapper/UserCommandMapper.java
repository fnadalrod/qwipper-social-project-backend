package com.qwipper.users.infrastructure.controller.mapper;

import com.qwipper.common.api.JsonApiRequest;
import com.qwipper.users.application.command.create.CreateUserCommand;
import com.qwipper.users.infrastructure.controller.api.dto.request.UserRequest;

public final class UserCommandMapper {
    private UserCommandMapper(){};

    public static CreateUserCommand toCommand(JsonApiRequest<UserRequest> request) {
        return new CreateUserCommand(
                request.getData().getAttributes().getUserName(),
                request.getData().getAttributes().getEmail(),
                request.getData().getAttributes().getPassword()
        );
    }
}
