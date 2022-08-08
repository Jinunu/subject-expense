package com.example.subject.dto;

import com.example.subject.domain.UsageType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseFormDto {
    private int expense;
    private UsageType usageType;
//    private int processing_state;
    private LocalDate useDate;
//    private LocalDate regDate;

}
