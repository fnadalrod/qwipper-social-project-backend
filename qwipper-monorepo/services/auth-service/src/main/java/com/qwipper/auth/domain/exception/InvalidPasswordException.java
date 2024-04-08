package com.qwipper.auth.domain.exception;

import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends AuthDomainException {

    public static final HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;
    public static final String ERROR_TITLE = "INVALID_PASSWORD";
    public static final String ERROR_DESCRIPTION = "Invalid password specified";

    public InvalidPasswordException() {
        super(
                ERROR_TITLE,
                ERROR_DESCRIPTION,
                HTTP_STATUS
        );
    }
}
