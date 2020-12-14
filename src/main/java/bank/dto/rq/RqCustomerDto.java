package bank.dto.rq;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RqCustomerDto {
    Long id;
    String name;
    String email;
    Integer age;
    List<RqAccountDto> accounts;
    List<RqEmployerDto> employers;

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
