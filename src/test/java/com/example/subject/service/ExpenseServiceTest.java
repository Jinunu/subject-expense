package com.example.subject.service;

import com.example.subject.dao.ExpenseMapper;
import com.example.subject.dto.ExpenseDetail;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ExpenseServiceTest {

    @Autowired
    ExpenseMapper expenseMapper;



}
