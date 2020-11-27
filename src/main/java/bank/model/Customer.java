package bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Customer extends AbstractModel {
    String name;
    String email;
    Integer age;
    List<Account> accounts = new ArrayList<>();

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

    public Account addAccount(Account account){
        accounts.add(account);
        return account;
    }

    public Account deleteAccount(Account account){
        accounts.remove(account);
        return account;
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
