package com.example.subject.dao;

import com.example.subject.domain.Expense;
import com.example.subject.domain.ProcessingState;
import com.example.subject.domain.UsageType;
import com.example.subject.dto.ExpenseDetail;
import com.example.subject.dto.ExpenseFormDto;
import com.example.subject.dto.SearchCondition;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

import static com.example.subject.domain.UsageType.*;

@Slf4j
@SpringBootTest
public class ExpenseDaoTest {

    @Autowired
    ExpenseMapper expenseMapper;

    @Test
    @Transactional
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
        //when
        expenseMapper.save(expense);
        ExpenseDetail expenseDetail = expenseMapper.getExpenseDetail(1L);
        Long currentExpenseId = expenseMapper.getCurrentExpenseId();
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
    @DisplayName("조건 검색")
    void searchWithSearchCondition() throws Exception{
        //given
        YearMonth yearMonth = YearMonth.of(2022, 8);
        log.info( yearMonth.toString());
        SearchCondition searchCondition = new SearchCondition();

        //when

        //then
    }


}
