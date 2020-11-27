package bank.service;

import bank.dao.AccountDao;
import bank.dao.CustomerDao;
import bank.dto.rs.RsAccountDto;
import bank.model.Account;
import bank.dto.rq.RqAccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountDao accountDao;
    private final CustomerDao customerDao;

    public String createAccount(RqAccountDto rqAccountDto){
         return customerDao.getOne(rqAccountDto.getCustomerId())
                .map(c -> {
                    Account account = new Account(rqAccountDto.getCurrency(), c);
                    c.addAccount(account);
                    accountDao.save(account);
                    return account.getNumber();
                })
                 .orElseThrow(NoSuchElementException::new);
    }

    public String deleteAccount(String number){
        return accountDao.findByNumber(number)
                .map(ac -> {
                    ac.getCustomer().deleteAccount(ac);
                    accountDao.delete(ac);
                    return ac.getNumber();
                })
                .orElseThrow(NoSuchElementException::new);
    }

    public RsAccountDto replenish(String to, Double amount){
        return accountDao.findByNumber(to)
                .map(n -> {
                    n.setBalance(n.getBalance() + amount);
                    return new RsAccountDto(n.getNumber(), n.getCurrency(), n.getBalance());
                })
                .orElseThrow(NoSuchElementException::new);
    }

    public RsAccountDto withdraw(String from, Double amount){
        return accountDao.findByNumber(from)
                .map(n -> {
                    if(n.getBalance() > amount) n.setBalance(n.getBalance() - amount);
                    else throw new ArithmeticException();
                    return new RsAccountDto(n.getNumber(), n.getCurrency(), n.getBalance());
                })
                .orElseThrow(NoSuchElementException::new);
    }

    public RsAccountDto transfer(String from, String to, Double amount) {
        if (accountDao.findByNumber(to).isPresent()){
            withdraw(from, amount);
            return replenish(to, amount);
        } else throw new NoSuchElementException();
    }
}
