package com.example.subject.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class File {
    private Long fileId;
    private Long expenseId;
    private String originalFileName;
    private String fileName;
}
