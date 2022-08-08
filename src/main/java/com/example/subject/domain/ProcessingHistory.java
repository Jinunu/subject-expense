package com.example.subject.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProcessingHistory {
    private Long processingHistoryNo;
    private Long expenseId;
    private LocalDate processingDate;
    private int approvalExpense;
    private String message;
}
