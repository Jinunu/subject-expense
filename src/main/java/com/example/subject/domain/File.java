package com.example.subject.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class File {
    private Long fileId;
    private Long expenseId;
    private String originalName;
    private String fileName;
}
