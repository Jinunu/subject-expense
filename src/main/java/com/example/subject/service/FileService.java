package com.example.subject.service;

import com.example.subject.dao.FileMapper;
import com.example.subject.domain.File;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {

    private final static String UPLOAD_DIR = "src/main/webapp/uploadFile";
    private final FileMapper fileMapper;

    @Transactional
    public void uploadFile(MultipartFile multipartFile, Long expenseId) throws IOException {
        String newFilePath = uploadDir(multipartFile);
        String fileName = getSubStringFileName(newFilePath);
        File saveFile = File.builder().
                expenseId(expenseId).
                originalName(multipartFile.getOriginalFilename()).
                fileName(fileName).
                build();
        fileMapper.save(saveFile);
    }

    private String uploadDir(MultipartFile multipartFile) throws IOException {
        String newFilePath = createNewFilePath(multipartFile);
        FileCopyUtils.copy(multipartFile.getBytes(), new java.io.File(newFilePath));
        return newFilePath;
    }

    private String getSubStringFileName(String newFilePath) {
        int index = newFilePath.lastIndexOf("/");
        String fileName = newFilePath.substring(index + 1);
        return fileName;
    }

    private String createNewFilePath(MultipartFile multipartFile) {
        String newFilePath = UPLOAD_DIR+"/"+UUID.randomUUID().toString()+ multipartFile.getOriginalFilename();
        return newFilePath;
    }

    public void editReceiptImage(MultipartFile multipartFile, Long fileId) throws IOException {
        //TODO 기존의 파일과 다를경우만 업데이트

        try {
            String newFilePath = uploadDir(multipartFile);
            String fileName = getSubStringFileName(newFilePath);
            File editFile = File.builder()
                    .fileName(fileName)
                    .fileId(fileId)
                    .originalName(multipartFile.getOriginalFilename())
                    .build();
            fileMapper.editImage(editFile);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }


    }

}
