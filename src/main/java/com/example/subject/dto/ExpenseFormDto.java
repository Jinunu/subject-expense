package com.example.subject.dto;

import com.example.subject.domain.code.UsageType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ExpenseFormDto {
    private Long expenseId;
    private Long fileId;
    @NotNull
    private int expense;
    @NotNull
    private UsageType usageType;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate useDate;
    @NotNull
    private MultipartFile receiptImage;

}
