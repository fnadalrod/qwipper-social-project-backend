package com.qwipper.common.error;

import org.springframework.http.HttpStatus;

public abstract class ApiException extends RuntimeException {
    private final String errorCode;
    private final HttpStatus httpStatus;

    protected ApiException(String errorCode, String message, HttpStatus httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
