package com.example.subject.util.validator;

import com.example.subject.dto.ExpenseFormDto;
import com.example.subject.error.CommonErrorCode;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ExpenseFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ExpenseFormDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiptImage", CommonErrorCode.INVALID_PARAMETER.getMessage(), "파일을 등록해 주세요");
    }
}
