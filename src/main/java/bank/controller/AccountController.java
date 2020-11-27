package bank.controller;

import bank.dto.rs.RsAccountDto;
import bank.model.Account;
import bank.dto.rq.RqOperationDto;
import bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("operations")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("replenish")
    public ResponseEntity<RsAccountDto> replenish(@RequestBody RqOperationDto rqOperationDto) {
        try {
            return ResponseEntity.ok(accountService.replenish(rqOperationDto.getTo(), rqOperationDto.getAmount()));
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("withdraw")
    public ResponseEntity<RsAccountDto> withdraw(@RequestBody RqOperationDto rqOperationDto) {
        try {
            return ResponseEntity.ok(accountService.withdraw(rqOperationDto.getFrom(), rqOperationDto.getAmount()));
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("transfer")
    public ResponseEntity<RsAccountDto> transfer(@RequestBody RqOperationDto rqOperationDto) {
        try {
            return ResponseEntity.ok(accountService.transfer(rqOperationDto.getFrom(), rqOperationDto.getTo(), rqOperationDto.getAmount()));
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
}
