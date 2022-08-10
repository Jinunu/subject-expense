package com.example.subject.dao;

import com.example.subject.domain.Expense;
import com.example.subject.dto.ExpenseDetail;
import com.example.subject.dto.ExpenseFormDto;
import com.example.subject.dto.ExpenseSearchResult;
import com.example.subject.dto.SearchCondition;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExpenseMapper {
    void save(Expense expense);
    ExpenseDetail getExpenseDetail(Long expenseId);
    Long getCurrentExpenseId();

    ExpenseSearchResult searchByExpense(SearchCondition searchCondition);
}
