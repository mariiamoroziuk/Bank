package bank.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customers")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employer extends BaseEntity {
    private String name;
    private String address;
    @ManyToMany(mappedBy = "employers")
    private Set<Customer> customers = new HashSet<>();
}
