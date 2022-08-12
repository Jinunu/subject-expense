package com.example.subject.controller;

import com.example.subject.dto.ExpenseFormDto;
import com.example.subject.dto.ExpenseSearchResult;
import com.example.subject.dto.SearchCondition;
import com.example.subject.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpensesController {
    public static final String BASIC_PATH = "/expense";
    private final ExpenseService expenseService;

    @GetMapping("/")
    public String index() {
        log.info("index");
        return "index";
    }

    @GetMapping("")
    public String expenseView() {
        return BASIC_PATH + "/expense";
    }

    @GetMapping("/expensePopup")
    public String expensePopup() {
        return BASIC_PATH + "/addExpensePopup";
    }

    @PostMapping("/save")
    @ResponseBody
    public String saveExpense(@ModelAttribute ExpenseFormDto expenseFormDto) throws IOException {
        expenseService.registerExpense(expenseFormDto);
        log.info("=================");
        return "success";
    }

    @PatchMapping("/search")
    @ResponseBody
    public ResponseEntity<List<ExpenseSearchResult>> searchExpenseList(@ModelAttribute SearchCondition searchCondition) {

        List<ExpenseSearchResult> expenseSearchResults = expenseService.searchExpenseList(searchCondition);
        ResponseEntity<List<ExpenseSearchResult>> success = ResponseEntity.ok(expenseSearchResults);
        return success;

    }
}
