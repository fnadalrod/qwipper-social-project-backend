package com.qwipper.users.domain.exception;

import org.springframework.http.HttpStatus;

public class EmptyUserNameException extends UserDomainException {

    public static final HttpStatus HTTP_STATUS = HttpStatus.UNPROCESSABLE_ENTITY;
    public static final String ERROR_TITLE = "EMPTY_USERNAME";
    public static final String ERROR_DESCRIPTION = "UserName can't be empty";

    public EmptyUserNameException() {
        super(
                ERROR_TITLE,
                ERROR_DESCRIPTION,
                HTTP_STATUS
        );
    }
}
