package com.project.staragile.banking.controller;

import com.project.staragile.banking.model.Account;
import com.project.staragile.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/createAccount")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PutMapping("/updateAccount/{accountNo}")
    public ResponseEntity<Account> updateAccount(@PathVariable String accountNo, @RequestBody Account accountDetails) {
        return accountService.updateAccount(accountNo, accountDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/viewPolicy/{accountNo}")
    public ResponseEntity<Account> viewAccount(@PathVariable String accountNo) {
        return accountService.viewAccount(accountNo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletePolicy/{accountNo}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String accountNo) {
        accountService.deleteAccount(accountNo);
        return ResponseEntity.noContent().build();
    }
}
