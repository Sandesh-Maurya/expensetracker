package moneytap.expensetracker.repository;

import moneytap.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense,Integer>{
    Optional<Expense> findById(Integer id);
}
