package com.example.subject.domain.code;

import com.example.subject.domain.CodeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UsageType implements CodeEnum {
    // 식대(야근) = 0, 택시비(야근) = 1, 택시비(회식) = 2, 사무용품 구매 = 3, 교육비 = 4, 접대비 = 5

    MEALS_NIGHT("0", "식대(야근)"),
    TAXI_NIGHT("1", "택시비(야근)"),
    TAXI_DINING_TOGETHER("2", "택시비(회식)"),
    OFFICE_EQUIPMENT("3", "사무용품 구매"),
    EDUCATIONAL_EXPENSES("4", "교육비"),
    ENTERTAINMENT("5", "접대비");
    @Getter
    public String code;
    @Getter
    public String title;

    UsageType(String code, String title
    ) {
        this.code = code;
        this.title = title;
    }


}
