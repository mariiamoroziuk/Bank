package bank.dto.rq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RqRecruitDto {
    private Long employer_id;
    private Long customer_id;
}
