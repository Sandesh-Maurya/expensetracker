package moneytap.expensetracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityScan(basePackages = {"com.mypackage.entity"})
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String password;
    @JsonIgnore
     @OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
     private  Set<Expense> expenses;
    @JsonIgnore
    @OneToMany(targetEntity = User.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name="cid"))
    private Set<Role> roles;

//    public User(Integer userID, String s, String s1) {
//    }
//    @JoinTable(name="user_expense",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="expense_id"))

}
