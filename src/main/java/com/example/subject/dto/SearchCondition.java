package com.example.subject.dto;

import com.example.subject.domain.code.ProcessingState;
import com.example.subject.domain.code.UsageType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.YearMonth;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchCondition {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    // 등록 연월로 검색
    private YearMonth rgeDateYearMonth;
    private LocalDate startRegDate;
    private LocalDate endRegDate;
    private UsageType usageType;
    private ProcessingState processingState;

   public LocalDate getStartRegDate(){
       return this.rgeDateYearMonth.atDay(1);
   }

    public LocalDate getEndRegDate() {
        return this.rgeDateYearMonth.atEndOfMonth();
    }
}
