package com.example.subject.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseDto {
    private int expense;
    private int usageType;
    private int processing_state;
    private LocalDate useDate;
    private LocalDate regDate;

}
