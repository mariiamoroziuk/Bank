package bank.dto.rq;

import bank.model.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class RqCustomerDto {
    Long id;
    String name;
    String email;
    Integer age;
    List<RqAccountDto> accounts;

    public RqCustomerDto(String name, String email, Integer age){
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public RqCustomerDto(Long id, String name, String email, Integer age){
        this(name, email, age);
        this.id = id;
    }
}
