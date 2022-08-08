package com.example.subject.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Expense {
    private Long expenseId;
    private int expense;
    private UsageType usageType;
    private ProcessingState processingState;
    private LocalDate useDate;
    private LocalDate regDate;

}
