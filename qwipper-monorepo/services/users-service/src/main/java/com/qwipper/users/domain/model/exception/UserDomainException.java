package com.qwipper.users.domain.model.exception;

import com.qwipper.common.error.ApiException;
import org.springframework.http.HttpStatus;

public class UserDomainException extends ApiException {

    public static final HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;

    public UserDomainException(String errorCode, String message, HttpStatus httpStatus) {
        super(errorCode, message, httpStatus);
    }
}