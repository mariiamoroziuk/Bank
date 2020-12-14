package bank.dto.rs;

import bank.dto.rq.RqEmployerDto;
import bank.model.Account;
import bank.model.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class RsCustomerDto implements Serializable {
    Long id;
    String name;
    String email;
    Integer age;
    List<RsAccountDto> accounts;
    List<RsEmployerDto> employers;

    public RsCustomerDto(String name, String email, Integer age){
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public RsCustomerDto(Long id, String name, String email, Integer age, List<Account> accounts, Set<Employer> employers){
        this(name, email, age);
        this.id = id;
        this.accounts = accounts.stream()
                .map(ac->new RsAccountDto(ac.getNumber(), ac.getCurrency(), ac.getBalance()))
                .collect(Collectors.toList());
        this.employers = employers.stream()
                .map(e->new RsEmployerDto(e.getId(), e.getName(), e.getAddress()))
                .collect(Collectors.toList());
    }
}
