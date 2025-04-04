package com.qwipper.common.error;


import com.qwipper.common.api.JsonApiErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<JsonApiErrorResponse> handleApiException(ApiException apiException, WebRequest request) {
        String path = request.getDescription(false).replace("uri=", "");
        return ResponseEntity
                .status(apiException.getHttpStatus())
                .body(JsonApiErrorResponse.fromException(apiException, path));
    }
}
