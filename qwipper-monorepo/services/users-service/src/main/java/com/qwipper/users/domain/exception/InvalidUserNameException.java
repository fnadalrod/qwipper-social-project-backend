package com.qwipper.users.domain.exception;

import org.springframework.http.HttpStatus;

public class InvalidUserNameException extends UserDomainException {

    public static final HttpStatus HTTP_STATUS = HttpStatus.UNPROCESSABLE_ENTITY;
    public static final String ERROR_TITLE = "INVALID_USERNAME_LENGTH";
    public static final String ERROR_DESCRIPTION = "UserName can't exceed 30 characters";

    public InvalidUserNameException() {
        super(
                ERROR_TITLE,
                ERROR_DESCRIPTION,
                HTTP_STATUS
        );
    }
}
