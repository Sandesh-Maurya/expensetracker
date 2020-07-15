package moneytap.expensetracker.controllers;

import moneytap.expensetracker.model.Expense;
import moneytap.expensetracker.repository.ExpenseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home")
public class ExpenseController {
    private ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository) {
        super();
        this.expenseRepository = expenseRepository;
    }
    @GetMapping("/expense")
    List<Expense> getExpenses(){return expenseRepository.findAll();}

    @DeleteMapping("/expenses/{id}")
    ResponseEntity<?>  deleteExpense(@PathVariable Integer id){
        expenseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/expense/{id}")
    ResponseEntity<?> getExpense(@PathVariable Integer id) {
        Optional<Expense> expense=expenseRepository.findById(id);
        return  expense.map(response->ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @PostMapping("/expense")
    ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) throws URISyntaxException {
        Expense newExpense=expenseRepository.save(expense);
        return ResponseEntity.created(new URI("/home/expense"+newExpense.getId())).body(newExpense);
    }


}
