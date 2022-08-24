package com.example.subject.controller.expense;

import com.example.subject.dto.*;
import com.example.subject.service.ExpenseService;
import com.example.subject.util.ExpenseExcelExporter;
import com.example.subject.util.validator.ExpenseFormValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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





    @GetMapping("/detail/{expenseId}")
    public String getExpenseDetail(@PathVariable Long expenseId, Model model) {
        ExpenseDetail detail = expenseService.getExpenseDetail(expenseId);
        model.addAttribute("detail", detail);
        return BASIC_PATH + "/expenseDetailPopup";
    }



    @PostMapping("/export/excel")
    public void exportToExcel(@ModelAttribute SearchCondition searchCondition, HttpServletResponse response) throws IOException {


        log.info(searchCondition.toString());
        response.setContentType("application/octet-stream");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormat.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=expense_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        List<ExpenseSearchResult> expenseSearchResults = expenseService.searchExpenseList(searchCondition);
        ExpenseExcelExporter excelExporter = new ExpenseExcelExporter(expenseSearchResults);

        excelExporter.export(response);
    }


}
