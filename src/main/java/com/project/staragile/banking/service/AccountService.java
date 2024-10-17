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

    public Optional<Account> updateAccount(String accountNo, Account accountDetails) {
        return accountRepository.findById(accountNo)
                .map(account -> {
                    account.setName(accountDetails.getName());
                    account.setBalance(accountDetails.getBalance());
                    return accountRepository.save(account);
                });
    }

    public Optional<Account> viewAccount(String accountNo) {
        return accountRepository.findById(accountNo);
    }

    public void deleteAccount(String accountNo) {
        accountRepository.deleteById(accountNo);
    }
}
