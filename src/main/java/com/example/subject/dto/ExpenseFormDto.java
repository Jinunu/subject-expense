package com.example.subject.dto;

import com.example.subject.domain.UsageType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class ExpenseFormDto {
    private int expense;
    private UsageType usageType;
//    private int processing_state;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate useDate;
//    private LocalDate regDate;
    private MultipartFile receiptImage;

}
