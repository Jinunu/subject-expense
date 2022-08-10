package com.example.subject.dao;

import com.example.subject.domain.File;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    void save(File file);

    File findByExpenseId(Long expenseId);
}
