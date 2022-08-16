package com.example.subject.dto;

import com.example.subject.domain.code.ProcessingState;
import com.example.subject.domain.code.UsageType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ExpenseDetail {

    private Long expenseId;
    private UsageType usageType;
    private int expense;
    private LocalDate useDate;
    private Long fileId;
    private String originalName;
    private String fileName;
    private ProcessingState processingState;
    private LocalDateTime processingDate; //시간까지 나와야하니 localDateTime으로 바꿔야하겠네
    private int approvalExpense;
    private String message;

}
