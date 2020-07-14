package moneytap.expensetracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name="user_expense",joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="expense_id",referencedColumnName = "id"))
    private Collection<Expense> expense;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Expense> getExpense() {
        return expense;
    }

    public void setExpense(Collection<Expense> expense) {
        this.expense = expense;
    }

    public User(Integer id, String name, String password, Collection<Expense> expense) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.expense = expense;
    }
}
