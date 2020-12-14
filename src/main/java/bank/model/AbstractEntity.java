package bank.model;

import lombok.Data;
import javax.persistence.*;

@Data
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
