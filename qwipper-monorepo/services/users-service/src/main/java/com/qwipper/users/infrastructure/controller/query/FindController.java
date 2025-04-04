package com.qwipper.users.infrastructure.controller.query;

import com.qwipper.common.api.JsonApiResponse;
import com.qwipper.common.api.Meta;
import com.qwipper.common.error.NoDataAvailableException;
import com.qwipper.users.application.find.GetUsersQuery;
import com.qwipper.users.application.find.GetUsersHandler;

import com.qwipper.users.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class FindController {
    private final GetUsersHandler handler;

    public FindController(GetUsersHandler handler) {
        this.handler = handler;
    }

    @GetMapping
    public ResponseEntity<JsonApiResponse> find() {
        List<User> users = handler.handle(new GetUsersQuery());

        if (users.isEmpty()) {
            throw new NoDataAvailableException();
        }

        return ResponseEntity.ok(JsonApiResponse.create(users, new Meta(users.size())));
    }
}