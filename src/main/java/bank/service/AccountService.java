package bank.service;

import bank.dto.rq.RqAccountDto;
import bank.dto.rs.RsAccountDto;
import bank.model.Account;
import bank.repo.AccountRepository;
import bank.repo.CustomerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repoA;
    private final CustomerRepository repoC;

    public String createAccount(RqAccountDto rqA){
         return repoC.findById(rqA.getCustomerId())
                .map(c -> {
                    Account account = new Account(rqA.getCurrency(), c);
                    c.addAccount(account);
                    Account saved = repoA.save(account);
                    return saved.getNumber();
                })
                 .orElseThrow(NoSuchElementException::new);
    }

    public String deleteAccount(String number){
        return repoA.findByNumber(number)
                .map(ac -> {
                    ac.getCustomer().deleteAccount(ac);
                    repoA.delete(ac);
                    return ac.getNumber();
                })
                .orElseThrow(NoSuchElementException::new);
    }

    public RsAccountDto replenish(String to, Double amount){
        return repoA.findByNumber(to)
                .map(n -> {
                    n.setBalance(n.getBalance() + amount);
                    return new RsAccountDto(n.getNumber(), n.getCurrency(), n.getBalance());
                })
                .orElseThrow(NoSuchElementException::new);
    }

    public RsAccountDto withdraw(String from, Double amount){
        return repoA.findByNumber(from)
                .map(n -> {
                    if(n.getBalance() > amount) n.setBalance(n.getBalance() - amount);
                    else throw new ArithmeticException();
                    return new RsAccountDto(n.getNumber(), n.getCurrency(), n.getBalance());
                })
                .orElseThrow(NoSuchElementException::new);
    }

    public RsAccountDto transfer(String from, String to, Double amount) {
        if (repoA.findByNumber(to).isPresent()){
            withdraw(from, amount);
            return replenish(to, amount);
        } else throw new NoSuchElementException();
    }
}
