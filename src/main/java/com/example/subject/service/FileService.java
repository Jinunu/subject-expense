package com.example.subject.service;

import com.example.subject.domain.FileUpload;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    private final static String UPLOAD_DIR = "src/main/webapp/uploadFile";
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        FileUpload fileUpload = new FileUpload();
        fileUpload.setOriginalFileName(multipartFile.getOriginalFilename());
        String newFilePath = UPLOAD_DIR+"/"+multipartFile.getOriginalFilename()+UUID.randomUUID().toString();
        FileCopyUtils.copy(multipartFile.getBytes(), new File(UPLOAD_DIR+"/"+multipartFile.getOriginalFilename()+UUID.randomUUID()));
        return newFilePath;
    }

    public FileUpload getFile(Long fileId) {
        FileUpload file = new FileUpload();
        return file;
    }
}
