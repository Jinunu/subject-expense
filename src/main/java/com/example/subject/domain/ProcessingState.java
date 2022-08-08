package com.example.subject.domain;

import lombok.Getter;

public enum ProcessingState{

    REGISTER(0),
    APPROVAL(1),
    DONE(2),
    REJECT(3);
    @Getter
    private int processingState; //접수(0), 승인(1), 지급완료(2), 반려(3)

    ProcessingState(int processingState) {
        this.processingState = processingState;
    }
}
