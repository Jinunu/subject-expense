package com.example.subject.dto;

import com.example.subject.domain.code.ProcessingState;
import com.example.subject.domain.code.UsageType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseSearchResult {
    private Long expenseId;
    private LocalDate useDate;
    private int expense;
    private int approvalExpense;
    private ProcessingState processingState;
    private UsageType usageType;
    private LocalDate regDate;
}
