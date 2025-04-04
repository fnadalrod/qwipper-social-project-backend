package com.qwipper.common.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qwipper.common.error.ApiException;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record JsonApiErrorResponse(
        @JsonProperty("errors") ErrorObject[] errors
) {
    public record ErrorObject(
            String status,
            String code,
            String title,
            String detail,
            Source source
    ) {}

    public record Source(
            String pointer,
            String parameter
    ) {}

    public static JsonApiErrorResponse fromException(ApiException ex, String path) {
        return new JsonApiErrorResponse(new ErrorObject[]{
                new ErrorObject(
                        String.valueOf(ex.getHttpStatus().value()),
                        ex.getErrorCode(),
                        ex.getHttpStatus().getReasonPhrase(),
                        ex.getMessage(),
                        new Source(path, null)
                )
        });
    }
}
