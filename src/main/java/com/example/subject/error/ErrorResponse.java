package com.example.subject.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ValidationError> errors;


    @Getter
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class ValidationError {
        private String field;
        private String message;

        public static ValidationError of(FieldError fieldError) {
            return ValidationError.builder()
                    .field(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build();
        }
    }

}
