package com.example.subject.service;

import com.example.subject.dao.ExpenseMapper;
import com.example.subject.domain.Expense;
import com.example.subject.dto.ExpenseFormDto;
import com.example.subject.dto.ExpenseSearchResult;
import com.example.subject.dto.SearchCondition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExpenseService {


    private final ExpenseMapper expenseMapper;
    private final FileService fileService;

    @Transactional
    public void registerExpense(ExpenseFormDto expenseFormDto) {
        Expense expense = expenseFormDtoToExpense(expenseFormDto);

        //TODO
        try {
            expenseMapper.save(expense);
            Long currentExpenseId = expenseMapper.getCurrentExpenseId();
            fileService.uploadFile(expenseFormDto.getReceiptImage(), currentExpenseId);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("파일 업로드 실패");
        }


    }

    public Expense expenseFormDtoToExpense(ExpenseFormDto expenseFormDto) {
        Expense expense = new Expense();
        expense.setExpense(expenseFormDto.getExpense());
        expense.setUsageType(expenseFormDto.getUsageType());
        expense.setUseDate(expenseFormDto.getUseDate());
        //TODO image 처리
        return expense;
    }

    public List<ExpenseSearchResult> searchExpenseList(SearchCondition searchCondition) {
        return expenseMapper.searchByExpense(searchCondition);
    }
}
