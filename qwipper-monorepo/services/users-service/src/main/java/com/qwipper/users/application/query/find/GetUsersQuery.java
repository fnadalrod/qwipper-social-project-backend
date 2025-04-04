package com.qwipper.users.application.query.find;

import com.qwipper.cqrs.query.Query;
import com.qwipper.users.domain.model.User;

import java.util.List;

public record GetUsersQuery() implements Query<List<User>> {}