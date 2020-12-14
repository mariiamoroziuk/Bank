package bank.service;

import bank.dto.rq.RqCustomerDto;
import bank.dto.rs.RsCustomerDto;
import bank.model.Customer;
import bank.model.Employer;
import bank.repo.CustomerRepository;
import bank.repo.EmployerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository repo;
    private final EmployerRepository repoE;

    public CustomerService(CustomerRepository repo, EmployerRepository repoE) {
        this.repo = repo;
        this.repoE = repoE;
    }

    public RsCustomerDto createCustomer(RqCustomerDto rqC) {
        Customer c = Customer.builder().name(rqC.getName()).email(rqC.getEmail()).age(rqC.getAge()).build();
        Customer saved = repo.save(c);
        return new RsCustomerDto( saved.getId(), saved.getName(), saved.getEmail(), saved.getAge(), saved.getAccounts(), saved.getEmployers());
    }

    public RsCustomerDto updateCustomer(RqCustomerDto rsC) {
        return repo.findById(rsC.getId())
                .map(c -> {
                    c.setName(rsC.getName());
                    c.setEmail(rsC.getEmail());
                    c.setAge(rsC.getAge());
                    Customer saved = repo.save(c);
                    return new RsCustomerDto(saved.getId(), saved.getName(), saved.getEmail(), saved.getAge(), saved.getAccounts(), saved.getEmployers());
                })
                .orElseThrow(NoSuchElementException::new);
    }

    public RsCustomerDto readCustomer(Long id){
        return repo.findById(id)
                .map(c->new RsCustomerDto(c.getId(), c.getName(), c.getEmail(), c.getAge(), c.getAccounts(), c.getEmployers()))
                .orElseThrow(NoSuchElementException::new);
    }

    public List<RsCustomerDto> readAllCustomers(){
        return repo.findAll().stream()
                .map(c->new RsCustomerDto(c.getId(), c.getName(), c.getEmail(), c.getAge(), c.getAccounts(), c.getEmployers()))
                .collect(Collectors.toList());
    }

    public Long deleteCustomer(Long id){
        Customer c = repo.findById(id).get();
        c.getEmployers().clear();
        repo.deleteById(id);
        return id;
    }
}
