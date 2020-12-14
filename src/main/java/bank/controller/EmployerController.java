package bank.controller;

import bank.dto.rq.RqCustomerDto;
import bank.dto.rq.RqEmployerDto;
import bank.dto.rq.RqRecruitDto;
import bank.dto.rs.RsCustomerDto;
import bank.dto.rs.RsEmployerDto;
import bank.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("employers")
@RequiredArgsConstructor
public class EmployerController {
    private final EmployerService employerService;

    @GetMapping
    public List<RsEmployerDto> readAll() {
        return employerService.readAllEmployers();
    }

    @GetMapping("{id}")
    public ResponseEntity<RsEmployerDto> read(@PathVariable("id") Long id) {
        try{
            RsEmployerDto e = employerService.readEmployer(id);
            return ResponseEntity.ok(e);
        } catch (NoSuchElementException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public RsEmployerDto create(@RequestBody RqEmployerDto e) {
        return employerService.createEmployer(e);
    }

    @PutMapping()
    public ResponseEntity<RsEmployerDto> update(@RequestBody RqEmployerDto e) {
        try {
            RsEmployerDto rsE = employerService.updateEmployer(e);
            return ResponseEntity.ok(rsE);
        }catch (NoSuchElementException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id){
        try{
            Long result = employerService.deleteEmployer(id);
            return ResponseEntity.ok(result);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("recruit")
    public ResponseEntity<RsEmployerDto> recruit(@RequestBody RqRecruitDto rqR) {
        try{
            RsEmployerDto rsE = employerService.recruit(rqR);
            return ResponseEntity.ok(rsE);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

}
