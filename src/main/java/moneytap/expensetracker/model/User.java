package moneytap.expensetracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name="user_expense",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="expense_id"))
    private Set<Expense> expense;
}
