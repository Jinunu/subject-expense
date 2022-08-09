package com.example.subject.service;

import com.example.subject.domain.File;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
public class FileService {

    private final static String UPLOAD_DIR = "src/main/webapp/uploadFile";

    @Transactional
    public void uploadFile(MultipartFile multipartFile) throws IOException {
        File file = new File();

        FileCopyUtils.copy(multipartFile.getBytes(), new java.io.File(createNewFilePath(multipartFile)));

        //TODO upload sql 만들것
    }

    private String createNewFilePath(MultipartFile multipartFile) {
        String newFilePath = UPLOAD_DIR+"/"+UUID.randomUUID().toString()+ multipartFile.getOriginalFilename();
        return newFilePath;
    }

}
