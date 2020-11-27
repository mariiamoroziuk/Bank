package bank.service;

import bank.dao.CustomerDao;
import bank.dto.rs.RsCustomerDto;
import bank.model.Customer;
import bank.dto.rq.RqCustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDao customerDao;

    public RsCustomerDto createCustomer(RqCustomerDto rqC){
        Customer c = new Customer(rqC.getName(), rqC.getEmail(), rqC.getAge());
        customerDao.save(c);
        return new RsCustomerDto(c.getId(), c.getName(), c.getEmail(), c.getAge(), c.getAccounts());
    }

    public RsCustomerDto updateCustomer(RqCustomerDto rsC){
        return customerDao.getOne(rsC.getId())
                .map(c->{
                    c.setName(rsC.getName());
                    c.setEmail(rsC.getEmail());
                    c.setAge(rsC.getAge());
                    customerDao.save(c);
                    return new RsCustomerDto(c.getId(), c.getName(), c.getEmail(), c.getAge(), c.getAccounts());
                })
                .orElseThrow(NoSuchElementException::new);
    }

    public RsCustomerDto readCustomer(Long id){
        return customerDao.getOne(id)
                .map(c->new RsCustomerDto(c.getId(), c.getName(), c.getEmail(), c.getAge(), c.getAccounts()))
                .orElseThrow(NoSuchElementException::new);
    }

    public List<RsCustomerDto> readAllCustomers(){
        return customerDao.findAll().stream()
                .map(c->new RsCustomerDto(c.getId(), c.getName(), c.getEmail(), c.getAge(), c.getAccounts()))
                .collect(Collectors.toList());
    }

    public Long deleteCustomer(Long id){
        boolean deleted = customerDao.deleteById(id);
        if(deleted) return id;
        else throw new NoSuchElementException();
    }
}
