package com.example.subject.dao;

import com.example.subject.domain.Expense;
import com.example.subject.domain.ProcessingState;
import com.example.subject.domain.UsageType;
import com.example.subject.dto.ExpenseDetail;
import com.example.subject.dto.ExpenseFormDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static com.example.subject.domain.UsageType.*;

@Slf4j
@SpringBootTest
public class ExpenseDaoTest {

    @Autowired
    ExpenseMapper expenseMapper;

    @Test
    void save() throws Exception{
        //given
//        ExpenseFormDto expenseFormDto = new ExpenseFormDto();
//        expenseFormDto.setExpense(3000);

        System.out.println(            EDUCATIONAL_EXPENSES.getCode()
        );
        ENTERTAINMENT.getCode();
        Expense expense = new Expense();
        expense.setExpense(3000);
        expense.setUseDate(LocalDate.now().minusDays(1));
        expense.setUsageType(EDUCATIONAL_EXPENSES);
//        expenseFormDto.setUsageType(MEALS_NIGHT);
        //when
        expenseMapper.save(expense);
        ExpenseDetail expenseDetail = expenseMapper.getExpenseDetail(1L);
        log.info(expenseDetail.toString());
        //then
    }

    @Test
    public void getExpenseDetail() throws Exception {
        //given
        Long expenseId = 1L;

        //when
        ExpenseDetail expenseDetail = expenseMapper.getExpenseDetail(expenseId);
        log.info(expenseDetail.toString());

        //then

    }

    @Test
    void asd() throws Exception{
        //given

        //when


        //then
    }

}
