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

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Long accountNo, Account accountDetails) {
        Optional<Account> account = accountRepository.findById(accountNo);
        if (account.isPresent()) {
            Account updatedAccount = account.get();
            updatedAccount.setAccountHolderName(accountDetails.getAccountHolderName());
            updatedAccount.setBalance(accountDetails.getBalance());
            return accountRepository.save(updatedAccount);
        }
        return null; // or throw an exception
    }

    public Optional<Account> viewAccount(Long accountNo) {
        return accountRepository.findById(accountNo);
    }

    public void deleteAccount(Long accountNo) {
        accountRepository.deleteById(accountNo);
    }
}
