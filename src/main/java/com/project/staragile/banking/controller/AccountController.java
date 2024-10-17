package com.project.staragile.banking.controller;

import com.project.staragile.banking.model.Account;
import com.project.staragile.banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/createAccount")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountRepository.save(account));
    }

    @PutMapping("/updateAccount/{accountNo}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long accountNo, @RequestBody Account accountDetails) {
        Optional<Account> account = accountRepository.findById(accountNo);
        if (account.isPresent()) {
            Account updatedAccount = account.get();
            updatedAccount.setAccountHolderName(accountDetails.getAccountHolderName());
            updatedAccount.setBalance(accountDetails.getBalance());
            return ResponseEntity.ok(accountRepository.save(updatedAccount));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/viewPolicy/{accountNo}")
    public ResponseEntity<Account> viewPolicy(@PathVariable Long accountNo) {
        return accountRepository.findById(accountNo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletePolicy/{accountNo}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long accountNo) {
        if (accountRepository.existsById(accountNo)) {
            accountRepository.deleteById(accountNo);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
