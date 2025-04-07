package com.qwipper.auth.domain.exception;

import com.qwipper.common.error.ApiException;
import org.springframework.http.HttpStatus;

public class AuthDomainException extends ApiException {

    public static final HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;

    public AuthDomainException(String errorCode, String message, HttpStatus httpStatus) {
        super(errorCode, message, httpStatus);
    }
}