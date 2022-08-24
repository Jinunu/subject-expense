package com.example.subject.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
public interface ErrorCode {

    String name();

    HttpStatus getHttpStatus();

    String getMessage();
}
