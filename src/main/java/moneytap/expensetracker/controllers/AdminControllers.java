package moneytap.expensetracker.controllers;
import moneytap.expensetracker.model.Expense;
import  moneytap.expensetracker.model.User;
import moneytap.expensetracker.repository.ExpenseRepository;
import moneytap.expensetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminControllers {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExpenseRepository expenseRepository;
    @GetMapping("/viewusers")
    public List<User> allUsers(){
        return userRepository.findAll();
    }

    @GetMapping("user/{userId}/expense")
    public List<Expense> getInfo(@PathVariable Integer userId){
        return expenseRepository.findByUsersId(userId);
    }
}
