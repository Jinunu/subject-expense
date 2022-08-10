package com.example.subject.dto;

import com.example.subject.domain.ProcessingState;
import com.example.subject.domain.UsageType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class SearchCondition {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    // 등록 연월로 검색 ex 2022-02 면 2월달거만 달로검색하네네
   private LocalDate rgeDate;
    private UsageType usageType;
    private ProcessingState processingState;
}
