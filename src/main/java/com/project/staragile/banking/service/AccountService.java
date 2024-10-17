package com.project.staragile.banking.service;

import com.project.staragile.banking.model.Account;
import com.project.staragile.banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Method to get account details by account number
    public Account getAccountDetails(Long accountNo) {
        Optional<Account> accountDetails = accountRepository.findById(accountNo);
        if (accountDetails.isPresent()) {
            // Use getAccountHolderName() to retrieve the name
            String name = accountDetails.get().getAccountHolderName(); // Correct method call
            // Further processing can be done here
            return accountDetails.get();
        }
        return null; // or throw an exception if account not found
    }

    // Method to create a new account
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // Method to delete an account by account number
    public void deleteAccount(Long accountNo) {
        accountRepository.deleteById(accountNo);
    }

    // Method to update an existing account
    public Account updateAccount(Long accountNo, Account updatedAccount) {
        return accountRepository.findById(accountNo)
                .map(account -> {
                    account.setAccountHolderName(updatedAccount.getAccountHolderName());
                    account.setBalance(updatedAccount.getBalance());
                    return accountRepository.save(account);
                })
                .orElseGet(() -> {
                    updatedAccount.setAccountNo(accountNo);
                    return accountRepository.save(updatedAccount);
                });
    }
}
