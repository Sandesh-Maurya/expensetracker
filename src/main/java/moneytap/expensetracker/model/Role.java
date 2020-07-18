package moneytap.expensetracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="role_table")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer role_id;
    private String roles;
    @ManyToOne
    private User users;
}

