package com.qwipper.common.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record JsonApiResponse<T>(
        @JsonProperty("data") T data,
        @JsonProperty("links") Links links,
        @JsonProperty("meta") Meta meta
) {
    public static <T> JsonApiResponse<T> create(T data, Meta meta) {
        return new JsonApiResponse<>(
                data,
                new Links(""),
                meta
        );
    }

    public static <T> JsonApiResponse<T> create(T data, int totalCount) {
        return new JsonApiResponse<>(
                data,
                new Links(""),
                new Meta(totalCount)
        );
    }
}