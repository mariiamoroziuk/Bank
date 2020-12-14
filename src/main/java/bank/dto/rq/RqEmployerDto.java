package bank.dto.rq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RqEmployerDto {
    Long id;
    String name;
    String address;

    public RqEmployerDto(String name, String address){
        this.name = name;
        this.address = address;
    }

    public RqEmployerDto(Long id, String name, String address){
        this(name, address);
        this.id = id;
    }
}
