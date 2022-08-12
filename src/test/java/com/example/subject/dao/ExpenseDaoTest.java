package com.example.subject.dao;

import com.example.subject.domain.Expense;
import com.example.subject.domain.code.ProcessingState;
import com.example.subject.domain.code.UsageType;
import com.example.subject.dto.ExpenseDetail;
import com.example.subject.dto.ExpenseSearchResult;
import com.example.subject.dto.SearchCondition;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import static com.example.subject.domain.code.ProcessingState.*;
import static com.example.subject.domain.code.UsageType.*;


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
    @DisplayName("조건 검색 등록연월이 null이 아닐 때")
    void searchConditionRegDateIsNotNull() throws Exception{
        //given


        SearchCondition searchCondition = new SearchCondition();
        YearMonth yearMonth = YearMonth.of(2022, 8);

        //when
        ArrayList<ExpenseSearchResult> expenseSearchResults = (ArrayList<ExpenseSearchResult>) expenseMapper.searchByExpense(searchCondition);
        //then
//        if (expenseSearchResults.size() != 0) {
//            assertThat(expenseSearchResults.get(0).getRegDate().getMonth()).isEqualTo(searchCondition.getRgeDateYearMonth().getMonth());
//        }

    }




    @Test
    public void searchConditionUsageTypeIsNotNull() throws Exception {
        //given
//        SearchCondition searchCondition = new SearchCondition();
        SearchCondition searchCondition = SearchCondition.builder().rgeDateYearMonth(YearMonth.of(2022, 8)).build();

        searchCondition.setUsageType(MEALS_NIGHT);
        System.out.println("searchCondition.getUsageType() = " + searchCondition.getUsageType().getCode());
        //when
        List<ExpenseSearchResult> expenseSearchResults = expenseMapper.searchByExpense(searchCondition);

        //then
        System.out.println("expenseSearchResults.toString() = " + expenseSearchResults.toString());
//        if( !expenseSearchResults.isEmpty()){
//            assertThat(expenseSearchResults).allMatch(expenseSearchResult -> expenseSearchResult.getUsageType() == MEALS_NIGHT);
//        }



    }

    @Test
    public void searchConditionProcessingStateIsNotNull() throws Exception {
        //given
        SearchCondition searchCondition = SearchCondition.builder().rgeDateYearMonth(YearMonth.of(2022, 8)).processingState(REGISTER).build();
        //when
        List<ExpenseSearchResult> expenseSearchResults = expenseMapper.searchByExpense(searchCondition);

        //then
        System.out.println("expenseSearchResults.toString() = " + expenseSearchResults.toString());

    }



}
