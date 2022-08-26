package com.example.subject.controller.expense;

import com.example.subject.dto.ExpenseFormDto;
import com.example.subject.dto.ExpenseSearchResult;
import com.example.subject.dto.ExpenseUpdateForm;
import com.example.subject.dto.SearchCondition;
import com.example.subject.service.ExpenseService;
import com.example.subject.util.validator.ExpenseFormValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ApiExpenses {

    private final ExpenseService expenseService;

    @InitBinder("expenseFormDto")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new ExpenseFormValidator());
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveExpense(@ModelAttribute @Valid ExpenseFormDto expenseFormDto) throws IOException, MethodArgumentNotValidException {

        expenseService.registerExpense(expenseFormDto);
        return ResponseEntity.ok("success");
    }

    @PatchMapping("/search")
    public ResponseEntity<List<ExpenseSearchResult>> searchExpenseList(@ModelAttribute @Valid SearchCondition searchCondition) {

        List<ExpenseSearchResult> expenseSearchResults = expenseService.searchExpenseList(searchCondition);
        ResponseEntity<List<ExpenseSearchResult>> success = ResponseEntity.ok(expenseSearchResults);
        return success;

    }
    @PutMapping()
    public String editExpense(@ModelAttribute @Valid ExpenseUpdateForm expenseUpdateForm) throws IOException {
        expenseService.editExpense(expenseUpdateForm);
        return "success";
    }

    @DeleteMapping("/{expenseId}")
    public String deleteExpense(@PathVariable Long expenseId) {
        expenseService.deleteExpense(expenseId);
        return "success";
    }

}
