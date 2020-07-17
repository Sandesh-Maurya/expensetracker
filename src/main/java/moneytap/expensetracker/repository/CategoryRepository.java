package moneytap.expensetracker.repository;

import moneytap.expensetracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByName(String  name);
    Category findByCid(Integer id) ;
}
