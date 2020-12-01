package bank.service;

import bank.dao.AccountDao;
import bank.dao.CustomerDao;
import bank.model.Account;
import bank.model.Currency;
import bank.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
//    public AccountDao ad;
//    public AccountService as;
//    public CustomerDao cd;
//    public CustomerService cs;
//    Customer c;

//    @BeforeEach
//    void init (){
//        ad = new AccountDao();
//        as = new AccountService(ad);
//        cd = new CustomerDao();
//        cs = new CustomerService(cd);
//        c = cs.createCustomer("SAM", "email", 28);
//    }

    @Test
    void topUp() {
//        Account account = as.createAccount(Currency.UAH, c);
//        as.topUp(account.getNumber(), 10.00);
//        assertEquals(10.00, account.getBalance());
    }

    @Test
    void withdraw() {
//        Account account = as.createAccount(Currency.UAH, c);
//        as.topUp(account.getNumber(), 100.00);
//        assertEquals(100.00, account.getBalance());
//        as.withdraw(account.getNumber(), 10.00);
//        assertEquals(90.00, account.getBalance());
////        as.withdraw(account.getNumber(), 100.00);
    }

    @Test
    void transfer() {
//        Account account1 = as.createAccount(Currency.UAH, c);
//        as.topUp(account1.getNumber(), 100.00);
//        Account account2 = as.createAccount(Currency.UAH, c);
//        as.topUp(account2.getNumber(), 200.00);
//        as.transfer(account2.getNumber(), account1.getNumber(), 50.00);
//        assertEquals(150.00, account1.getBalance());
//        assertEquals(150.00, account2.getBalance());
    }
}