package bank.dto.rq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RqOperationDto {
    private String from;
    private String to = null;
    private Double amount;
}
