package com.example.subject;

import com.example.subject.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FIleServiceTest {

    @Autowired
    FileService fileService;

    @Test
    void filePath() throws Exception{
        //given
        System.out.println(System.getProperty("user.dir"));
        
        //when

        //then
    }
}
