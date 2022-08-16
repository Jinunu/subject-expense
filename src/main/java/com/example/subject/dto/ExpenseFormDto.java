package com.example.subject.dto;

import com.example.subject.domain.code.UsageType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class ExpenseFormDto {
    private Long expenseId;
    private Long fileId;
    private int expense;
    private UsageType usageType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate useDate;
    private MultipartFile receiptImage;

}
