package bank.controller;

import bank.dto.rq.RqAccountDto;
import bank.dto.rs.RsCustomerDto;
import bank.dto.rq.RqCustomerDto;
import bank.service.AccountService;
import bank.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final AccountService accountService;

    @GetMapping
    public List<RsCustomerDto> readAll() {
        return customerService.readAllCustomers();
    }

    @GetMapping("{id}")
    public ResponseEntity<RsCustomerDto> read(@PathVariable("id") Long id) {
        try{
            RsCustomerDto c = customerService.readCustomer(id);
            return ResponseEntity.ok(c);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public RsCustomerDto create(@RequestBody RqCustomerDto rqCustomerDto) {
        return customerService.createCustomer(rqCustomerDto);
    }

    @PutMapping()
    public ResponseEntity<RsCustomerDto> update(@RequestBody RqCustomerDto rqCustomerDto) {
        try {
            RsCustomerDto c = customerService.updateCustomer(rqCustomerDto);
            return ResponseEntity.ok(c);
        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id){
        try{
            Long result = customerService.deleteCustomer(id);
            return ResponseEntity.ok(result);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("accounts")
    public ResponseEntity<String> createAccount(@RequestBody RqAccountDto rqAccountDto){
        try{
            String result = accountService.createAccount(rqAccountDto);
            return ResponseEntity.ok(result);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("accounts/{number}")
    public ResponseEntity<String> deleteAccount(@PathVariable("number") String number){
        try{
            String result = accountService.deleteAccount(number);
            return ResponseEntity.ok(result);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

}
