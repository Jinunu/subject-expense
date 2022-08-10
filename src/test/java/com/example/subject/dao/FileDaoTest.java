package com.example.subject.dao;

import com.example.subject.domain.File;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
public class FileDaoTest {

    @Autowired
    FileMapper fileMapper;

    @Test
    @DisplayName("파일 저장")
    void save() throws Exception{
        //given
        File file = File.builder()
                .expenseId(1L)
                .fileName("영수증경로")
                .originalName("원래이름")
                .build();
        //when
        fileMapper.save(file);
        //then
    }

    @Test
    @DisplayName("expensId로 영수증 이미지 조회")
    void findByExpenseId() throws Exception{
        //given
        Long expenseId = 1L;
        //when
        File findFile = fileMapper.findByExpenseId(expenseId);
        //then
        assertThat(findFile.getFileId()).isEqualTo(1L);
    }
}
