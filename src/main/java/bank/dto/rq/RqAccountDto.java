package bank.dto.rq;

import bank.model.Currency;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class RqAccountDto implements Serializable {
    private Currency currency;
    private Long customerId;

    public RqAccountDto(Currency currency, Long customerId){
        this.currency = currency;
        this.customerId = customerId;
    }
}
