package com.example.subject.dto;

import com.example.subject.domain.ProcessingState;
import com.example.subject.domain.UsageType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseSearchResult {
    private Long expenseId;
    private LocalDate useDate;
    private UsageType usageType;
    private int expense;
    private int approvalExpense;
    private ProcessingState processingState;
    private LocalDate regDate;
}
