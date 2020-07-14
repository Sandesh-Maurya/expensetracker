package moneytap.expensetracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.time.Instant;

//@NoArgsConstructor
//@Data
//@AllArgsConstructor
@Entity
@Table(name="expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Instant date;
    private Integer price;
    private String  expenseDetails;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name="user_expense",joinColumns = @JoinColumn(name="expense_id"),inverseJoinColumns = @JoinColumn(name="user_id"))
    private User user;

    public Expense() {
    }

    public Expense(Integer id, Instant date, Integer price, String expenseDetails, User user) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.expenseDetails = expenseDetails;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getExpenseDetails() {
        return expenseDetails;
    }

    public void setExpenseDetails(String expenseDetails) {
        this.expenseDetails = expenseDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //    @ManyToOne
//    private Category category;
////
//    @ManyToOne
//    private User user;

}
