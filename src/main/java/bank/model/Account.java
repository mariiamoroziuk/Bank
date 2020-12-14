package bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private Currency currency;
    private Double balance = 0.00;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Account(Currency currency, Customer customer){
        this.currency = currency;
        this.customer = customer;
        this.number = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + getId() + '\'' +
                "number='" + number + '\'' +
                ", currency=" + currency +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(customer, account.customer) &&
                Objects.equals(number, account.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, number);
    }
}
