package bank.service;

import bank.dto.rq.RqEmployerDto;
import bank.dto.rq.RqRecruitDto;
import bank.dto.rs.RsEmployerDto;
import bank.model.Employer;
import bank.repo.CustomerRepository;
import bank.repo.EmployerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class EmployerService {
    public final EmployerRepository repoE;
    public final CustomerRepository repoC;

    public EmployerService(EmployerRepository repoE, CustomerRepository repoC) {
        this.repoE = repoE;
        this.repoC = repoC;
    }

    public RsEmployerDto createEmployer(RqEmployerDto rqE) {
        Employer e = Employer.builder().name(rqE.getName()).address(rqE.getAddress()).build();
        Employer saved = repoE.save(e);
        return new RsEmployerDto(saved.getId(), saved.getName(), saved.getAddress(), saved.getCustomers());
    }

    public RsEmployerDto updateEmployer(RqEmployerDto rsE) {
        return repoE.findById(rsE.getId())
                .map(e -> {
                    e.setName(rsE.getName());
                    e.setAddress(rsE.getAddress());
                    Employer saved = repoE.save(e);
                    return new RsEmployerDto(saved.getId(), saved.getName(), saved.getAddress(), saved.getCustomers());
                })
                .orElseThrow(NoSuchElementException::new);
    }

    public RsEmployerDto readEmployer(Long id){
        return repoE.findById(id)
                .map(c->new RsEmployerDto(c.getId(), c.getName(), c.getAddress(), c.getCustomers()))
                .orElseThrow(NoSuchElementException::new);
    }

    public List<RsEmployerDto> readAllEmployers(){
        return repoE.findAll().stream()
                .map(c->new RsEmployerDto(c.getId(), c.getName(), c.getAddress(), c.getCustomers()))
                .collect(Collectors.toList());
    }

    public Long deleteEmployer(Long id){
        repoE.deleteById(id);
        return id;
    }

    public RsEmployerDto recruit(RqRecruitDto rqR){
        return repoC.findById(rqR.getCustomer_id())
                .flatMap(c -> repoE.findById(rqR.getEmployer_id())
                        .map((e)-> {
                            c.getEmployers().add(e);
                            e.getCustomers().add(c);
                            Employer saved = repoE.save(e);
                            return new RsEmployerDto(saved.getId(), saved.getName(), saved.getAddress(), saved.getCustomers());
                        }))
                .orElseThrow(NoSuchElementException::new);
    }
}
