package bank.dto.rs;

import bank.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class RsAccountDto implements Serializable {
    String number;
    Currency currency;
    Double balance;
}
