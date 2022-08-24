package com.example.subject.dto;

import com.example.subject.domain.code.UsageType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
public class ExpenseFormDto {
    @NotNull
    @Positive
    private int expense;
    @NotNull
    private UsageType usageType;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate useDate;
    private MultipartFile receiptImage;

}
