package bank.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;
    String email;
    Integer age;

    @OneToMany (mappedBy="customer")
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

    public Customer(String name, String email, Integer age){
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Customer(Long id, String name, String email, Integer age, List<Account> accounts){
        this(name, email, age);
        this.setId(id);
        this.setAccounts(accounts);
    }

    public Customer(Long id, String name, String email, Integer age, List<Account> accounts, HashSet<Employer> employers){
        this(id, name, email, age, accounts);
        this.setEmployers(employers);
    }

    public Account addAccount(Account account){
        accounts.add(account);
        return account;
    }

    public Account deleteAccount(Account account){
        accounts.remove(account);
        return account;
    }

    public Employer addEmployer(Employer e){
        employers.add(e);
        return e;
    }

    public Employer deleteEmployer(Employer e){
        employers.remove(e);
        return e;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", accounts=" + accounts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(age, customer.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, age);
    }
}
