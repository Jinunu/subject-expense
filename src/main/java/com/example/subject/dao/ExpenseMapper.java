package com.example.subject.dao;

import com.example.subject.dto.ExpenseDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExpenseMapper {
    void save(ExpenseDto expenseDto);
}
