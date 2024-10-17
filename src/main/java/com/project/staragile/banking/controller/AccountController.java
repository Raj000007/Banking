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

    @GetMapping("/viewAccount/{accountNo}")  // Updated to viewAccount for clarity
    public ResponseEntity<Account> viewAccount(@PathVariable Long accountNo) {
        Account account = accountService.getAccountDetails(accountNo);  // Changed to getAccountDetails
        return account != null ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteAccount/{accountNo}")  // Updated to deleteAccount for clarity
    public ResponseEntity<Void> deleteAccount(@PathVariable Long accountNo) {
        accountService.deleteAccount(accountNo);
        return ResponseEntity.noContent().build();
    }
}
