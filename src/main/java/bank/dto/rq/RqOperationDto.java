package bank.dto.rq;

import bank.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RqOperationDto {
    private String from;
    private String to = null;
    private Double amount;
}
