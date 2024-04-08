package com.qwipper.auth.domain.exception;

import org.springframework.http.HttpStatus;

public class UserDoesNotExistException extends AuthDomainException {

    public static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;
    public static final String ERROR_TITLE = "USER_NOT_EXISTS";
    public static final String ERROR_DESCRIPTION = "User does not exist";

    public UserDoesNotExistException() {
        super(
                ERROR_TITLE,
                ERROR_DESCRIPTION,
                HTTP_STATUS
        );
    }
}
