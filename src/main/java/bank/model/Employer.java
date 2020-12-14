package bank.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
@NoArgsConstructor
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;


    @ManyToMany(mappedBy = "employers")
    private Set<Customer> customers= new HashSet<>();

    public Employer(String name, String address){
      this.name = name;
      this.address = address;
    }

    public Employer(String name, String address, Set<Customer> customers){
        this(name, address);
        this.customers = customers;
    }
    public Employer(Long id, String name, String address, Set<Customer> customers){
        this(name, address, customers);
        this.id = id;
    }
    public Customer addCustomer(Customer c){
        customers.add(c);
        return c;
    }

    public Customer deleteCustomer(Customer c){
        customers.remove(c);
        return c;
    }
}
