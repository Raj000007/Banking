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
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @PutMapping("/updateAccount/{accountNo}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long accountNo, @RequestBody Account accountDetails) {
        Account updatedAccount = accountService.updateAccount(accountNo, accountDetails);
        return updatedAccount != null ? ResponseEntity.ok(updatedAccount) : ResponseEntity.notFound().build();
    }

    @GetMapping("/viewPolicy/{accountNo}")
    public ResponseEntity<Account> viewPolicy(@PathVariable Long accountNo) {
        Optional<Account> account = accountService.viewAccount(accountNo);
        return account.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletePolicy/{accountNo}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long accountNo) {
        accountService.deleteAccount(accountNo);
        return ResponseEntity.noContent().build();
    }
}
