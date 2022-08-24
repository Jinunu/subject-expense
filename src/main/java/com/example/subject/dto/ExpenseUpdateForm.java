package com.example.subject.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ExpenseUpdateForm extends ExpenseFormDto {
    @NotNull
    private Long expenseId;
    private Long fileId;
}
