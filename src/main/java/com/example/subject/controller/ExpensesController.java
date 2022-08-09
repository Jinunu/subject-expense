package com.example.subject.controller;

import com.example.subject.domain.UsageType;
import com.example.subject.dto.ExpenseFormDto;
import com.example.subject.service.ExpenseService;
import com.example.subject.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpensesController {
    public static final String BASIC_PATH = "/expense";
    private final ExpenseService expenseService;

    @GetMapping("/")
    public String index(){
        log.info("index");
        return "index";
    }

    @GetMapping("")
    public String expenseView() {
        return BASIC_PATH+"/expense";
    }

    @GetMapping("/expensePopup")
    public String expensePopup() {
        return BASIC_PATH + "/addExpensePopup";
    }

    @PostMapping("/save")
    public String saveExpense(@ModelAttribute ExpenseFormDto expenseFormDto) throws IOException {
        expenseService.registerExpense(expenseFormDto);

        return "redirect:"+BASIC_PATH;
    }


}
