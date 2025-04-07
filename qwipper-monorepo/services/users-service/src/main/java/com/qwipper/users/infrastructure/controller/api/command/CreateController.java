package com.qwipper.users.infrastructure.controller.api.command;

import com.qwipper.common.api.JsonApiRequest;
import com.qwipper.users.application.command.create.CreateUserCommandHandler;

import com.qwipper.users.infrastructure.controller.api.dto.request.UserRequest;
import com.qwipper.users.infrastructure.controller.mapper.UserCommandMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class CreateController {
    private final CreateUserCommandHandler handler;

    public CreateController(CreateUserCommandHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody JsonApiRequest<UserRequest> request) {
        handler.handle(UserCommandMapper.toCommand(request));

        return ResponseEntity.noContent().build();
    }
}