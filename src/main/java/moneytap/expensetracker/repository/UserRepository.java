package moneytap.expensetracker.repository;

import moneytap.expensetracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByName(String name);
}
