package com.example.subject.service;

import com.example.subject.dao.ExpenseMapper;
import com.example.subject.domain.Expense;
import com.example.subject.dto.ExpenseFormDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseMapper expenseMapper;
    FileService fileService = new FileService();

    public void registerExpense(ExpenseFormDto expenseFormDto) throws IOException {
        Expense expense = expenseFormDtoToExpense(expenseFormDto);
        expenseMapper.save(expense);
        String fileName = fileService.uploadFile(expenseFormDto.getReceiptImage());

        log.info(fileName, fileName);

    }

    public Expense expenseFormDtoToExpense(ExpenseFormDto expenseFormDto) {
        Expense expense = new Expense();
        expense.setExpense(expenseFormDto.getExpense());
        expense.setUsageType(expenseFormDto.getUsageType());
        expense.setUseDate(expenseFormDto.getUseDate());
        //TODO image 처리
        return expense;
    }
}
