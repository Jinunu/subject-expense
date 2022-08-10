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
        String newFilePath = createNewFilePath(multipartFile);
        FileCopyUtils.copy(multipartFile.getBytes(), new java.io.File(newFilePath));
        File saveFile = File.builder().
                expenseId(expenseId).
                originalName(multipartFile.getOriginalFilename()).
                fileName(newFilePath).
                build();
        //TODO upload sql 만들것
        fileMapper.save(saveFile);
    }

    private String createNewFilePath(MultipartFile multipartFile) {
        String newFilePath = UPLOAD_DIR+"/"+UUID.randomUUID().toString()+ multipartFile.getOriginalFilename();
        return newFilePath;
    }

}
