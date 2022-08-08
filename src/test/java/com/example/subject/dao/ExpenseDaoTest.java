package com.example.subject.dao;

import com.example.subject.dto.ExpenseDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ExpenseDaoTest {

    @Autowired
    ExpenseMapper expenseMapper;

    @Test
    void save() throws Exception{
        //given
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setExpense(3000);
        //when

        //then
    }
}
