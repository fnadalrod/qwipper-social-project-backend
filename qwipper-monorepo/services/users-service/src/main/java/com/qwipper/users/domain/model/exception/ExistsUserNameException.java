package com.qwipper.users.domain.model.exception;

import org.springframework.http.HttpStatus;

public class ExistsUserNameException extends UserDomainException {

    public static final HttpStatus HTTP_STATUS = HttpStatus.CONFLICT;
    public static final String ERROR_TITLE = "REPEATED_USERNAME";
    public static final String ERROR_DESCRIPTION = "UserName already exists";

    public ExistsUserNameException() {
        super(
                ERROR_TITLE,
                ERROR_DESCRIPTION,
                HTTP_STATUS
        );
    }
}
