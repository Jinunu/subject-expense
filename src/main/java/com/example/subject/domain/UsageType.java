package com.example.subject.domain;

import lombok.Getter;

public enum UsageType implements CodeEnum{
    // 식대(야근) = 0, 택시비(야근) = 1, 택시비(회식) = 2, 사무용품 구매 = 3, 교육비 = 4, 접대비 = 5

    MEALS_NIGHT("0"),
    TAXI_NIGHT("1"),
    TAXI_DINING_TOGETHER("2"),
    OFFICE_EQUIPMENT("3"),
    EDUCATIONAL_EXPENSES("4"),
    ENTERTAINMENT("5");
    @Getter
    public String code;

    UsageType(String code
    ) {
        this.code = code;
    }


}
