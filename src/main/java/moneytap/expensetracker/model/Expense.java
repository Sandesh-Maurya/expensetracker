package moneytap.expensetracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.time.Instant;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name="user_expense",joinColumns = @JoinColumn(name="expense_id"),inverseJoinColumns = @JoinColumn(name="user_id"))
    private User user;

//    @ManyToOne
//    private Category category;
////
//    @ManyToOne
//    private User user;

}
