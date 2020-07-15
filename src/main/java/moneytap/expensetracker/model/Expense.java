package moneytap.expensetracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name="expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Instant date;
    private Integer price;
    private String  expenseDetails;

    public Expense(Integer id, Instant date, Integer price, String expenseDetails, Integer UserID, Integer c_Id) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.expenseDetails = expenseDetails;
        this.users = new User(UserID,"","",null);
        this.category = new Category(c_Id,"");
    }

    //
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinTable(name="user_expense",joinColumns = @JoinColumn(name="expense_id"),inverseJoinColumns = @JoinColumn(name="user_id"))
//    private User user;
    @JsonIgnore
    @ManyToOne
    private  User users;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;



}
