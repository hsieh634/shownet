package com.shownet.travel.shared.api;

import java.time.Instant;
import java.util.List;

public record ApiError(
        String code,
        String message,
        int status,
        String path,
        String traceId,
        Instant timestamp,
        List<FieldError> fieldErrors
) {
    public record FieldError(String field, String message) {
    }
}

