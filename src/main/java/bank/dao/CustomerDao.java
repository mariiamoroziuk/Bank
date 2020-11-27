package bank.dao;

import bank.model.Account;
import bank.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class CustomerDao extends AbstractBankDao<Customer>{

    public CustomerDao() {
        super(new ArrayList<>(), 1L);
        Customer c1 = new Customer("SAM", "yyyy", 45);
        c1.setId(11l);
        list.add(c1);
        Customer c2 = new Customer("Jimmy", "dhdhd", 23);
        c2.setId(12l);
        list.add(c2);
        Customer c3 = new Customer("Tony", "zzzz", 16);
        c3.setId(13l);
        list.add(c3);
    }

}
