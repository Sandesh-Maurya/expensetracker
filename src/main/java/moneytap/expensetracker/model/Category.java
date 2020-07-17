package moneytap.expensetracker.model;

import lombok.*;

import javax.persistence.*;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cid;
    private String name;


}
