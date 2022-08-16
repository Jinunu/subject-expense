package com.example.subject.domain;

import com.example.subject.domain.code.ProcessingState;
import com.example.subject.domain.code.UsageType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Expense {
    private Long expenseId;
    private int expense;
    private UsageType usageType;
    private ProcessingState processingState;
    private LocalDate useDate;
    private LocalDate regDate;
    private LocalDateTime processingDate;
    private int approvalExpense;
    private String message;
    //이미지 추가할것

}
