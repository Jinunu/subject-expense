package com.example.subject.dao;

import com.example.subject.domain.Expense;
import com.example.subject.dto.ExpenseDetail;
import com.example.subject.dto.ExpenseSearchResult;
import com.example.subject.dto.SearchCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExpenseMapper {
    void save(Expense expense);
    ExpenseDetail getExpenseDetail(Long expenseId);
    Long getCurrentExpenseId();
    List<ExpenseSearchResult> searchByExpense(SearchCondition searchCondition);

}
