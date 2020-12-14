package bank.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customers")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {
    String name;
    String email;
    Integer age;

    @OneToMany(mappedBy = "customer")
    @OnDelete(action = OnDeleteAction.CASCADE)
    List<Account> accounts = new ArrayList<>();

    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "customer_employer",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "employer_id")}
    )
    Set<Employer> employers = new HashSet<>();
}
