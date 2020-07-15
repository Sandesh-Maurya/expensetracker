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
