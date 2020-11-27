package bank.dao;

import bank.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class AccountDao extends AbstractBankDao<Account> {

    public AccountDao() {
        super(new ArrayList<>(), 1L);
    }

    public Optional<Account> findByNumber(String number){
        return list.stream()
                .filter(ac-> ac.getNumber().equals(number))
                .findFirst();
    }
}
