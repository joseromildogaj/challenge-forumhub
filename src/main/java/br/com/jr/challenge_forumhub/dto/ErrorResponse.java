package br.com.jr.challenge_forumhub.dto;

import java.time.Instant;
import java.util.List;

public record ErrorResponse(
        Instant timestamp,
        int status,
        String error,
        String message,
        List<ValidationError> validationErrors
) {

    public record ValidationError(String field, String message) {
    }
}