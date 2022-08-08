package com.example.subject.dto;

import com.example.subject.domain.ProcessingState;
import com.example.subject.domain.UsageType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseDetail {

    private Long expenseId;
    private int expense;
    private UsageType usageType;
    private ProcessingState processingState;
    private LocalDate useDate;
    private LocalDate processingDate;
    private int approvalExpense;
    private String message;

}
