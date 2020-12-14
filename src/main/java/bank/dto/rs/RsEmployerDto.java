package bank.dto.rs;

import bank.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class RsEmployerDto implements Serializable {
    Long id;
    String name;
    String address;
    List<String> customers = new ArrayList<>();

    public RsEmployerDto(Long id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public RsEmployerDto(Long id, String name, String address, Set<Customer> customers){
        this(id, name, address);

        this.customers = customers.stream().map(Customer::getName)
                .collect(Collectors.toList());
    }
}
