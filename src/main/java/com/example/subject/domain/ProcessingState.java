package com.example.subject.domain;

import lombok.Getter;

public enum ProcessingState implements CodeEnum{

    REGISTER("0", "접수"),
    APPROVAL("1", "승인"),
    DONE("2", "지급완료"),
    REJECT("3", "반려");

    @Getter
    private String code; //접수(0), 승인(1), 지급완료(2), 반려(3)

    @Getter
    private String title;

    ProcessingState(String code, String title) {
        this.code = code;
        this.title = title;
    }
}
