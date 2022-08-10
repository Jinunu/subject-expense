package com.example.subject;

import com.example.subject.dao.FileMapper;
import com.example.subject.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FIleServiceTest {

    @Autowired
    FileService fileService;
    @Autowired
    FileMapper fileMapper;

    @Test
    void uploadImage() throws Exception{


    }
}
