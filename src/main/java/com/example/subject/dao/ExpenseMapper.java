package com.example.subject.dao;

import com.example.subject.domain.Expense;
import com.example.subject.dto.ExpenseDetail;
import com.example.subject.dto.ExpenseFormDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExpenseMapper {
    void save(Expense expense);
    ExpenseDetail getExpenseDetail(Long expenseId);
}
