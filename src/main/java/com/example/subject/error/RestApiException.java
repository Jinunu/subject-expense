package com.example.subject.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RestApiException extends RuntimeException{

    private final ErrorCode errorCode;
}
