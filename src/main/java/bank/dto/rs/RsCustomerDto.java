package bank.dto.rs;

import bank.model.Account;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class RsCustomerDto implements Serializable {
    Long id;
    String name;
    String email;
    Integer age;
    List<RsAccountDto> accounts;

    public RsCustomerDto(Long id, String name, String email, Integer age, List<Account> accounts){
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.accounts = accounts.stream()
                .map(ac->new RsAccountDto(ac.getNumber(), ac.getCurrency(), ac.getBalance()))
                .collect(Collectors.toList());
    }
}
