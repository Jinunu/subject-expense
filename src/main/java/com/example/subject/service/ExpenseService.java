package com.example.subject.service;

import com.example.subject.dao.ExpenseMapper;
import com.example.subject.domain.Expense;
import com.example.subject.dto.*;
import com.example.subject.error.CommonErrorCode;
import com.example.subject.error.RestApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

        try {
            expenseMapper.save(expense);
            Long currentExpenseId = expenseMapper.getCurrentExpenseId();
            fileService.uploadFile(expenseFormDto.getReceiptImage(), currentExpenseId);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RestApiException(CommonErrorCode.INVALID_PARAMETER);
        }


    }

    public Expense expenseFormDtoToExpense(ExpenseFormDto expenseFormDto) {
        Expense expense = new Expense();
        expense.setExpense(expenseFormDto.getExpense());
        expense.setUsageType(expenseFormDto.getUsageType());
        expense.setUseDate(expenseFormDto.getUseDate());
        return expense;
    }

    public List<ExpenseSearchResult> searchExpenseList(SearchCondition searchCondition) {
        return expenseMapper.searchByExpense(searchCondition);
    }

    public ExpenseDetail getExpenseDetail(Long expenseId) {
        return expenseMapper.getExpenseDetail(expenseId);
    }

    @Transactional
    public void editExpense(ExpenseUpdateForm expenseUpdateForm) throws IOException {
        expenseMapper.update(expenseUpdateForm);
        if (expenseUpdateForm.getReceiptImage() != null) {
            fileService.editReceiptImage(expenseUpdateForm.getReceiptImage(), expenseUpdateForm.getFileId());
        }
    }

    @Transactional
    public void deleteExpense(Long expenseId) {
        expenseMapper.deleteExpense(expenseId);
    }
}
