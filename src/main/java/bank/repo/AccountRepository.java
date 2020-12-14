package bank.repo;

import bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
        public Optional<Account> findByNumber(String number);
}

