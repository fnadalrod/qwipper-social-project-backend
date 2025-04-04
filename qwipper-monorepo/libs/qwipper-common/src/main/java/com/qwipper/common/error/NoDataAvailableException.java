package com.qwipper.common.error;

import org.springframework.http.HttpStatus;

public class NoDataAvailableException extends ApiException {

    public static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;
    public static final String ERROR_TITLE = "EMPTY_DATA";
    public static final String ERROR_DESCRIPTION = "No data was found";

    public NoDataAvailableException() {
        super(
                ERROR_TITLE,
                ERROR_DESCRIPTION,
                HTTP_STATUS
        );
    }
}
