package com.example.subject.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileUpload {
    private Long fileId;
    private String originalFileName;
    private String filePath;
}
