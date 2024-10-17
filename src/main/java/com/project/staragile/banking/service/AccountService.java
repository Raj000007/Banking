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

    public Account updateAccount(String accountNo, Account accountDetails) {
        Account account = accountRepository.findByAccountNo(accountNo);
        if (account != null) {
            account.setName(accountDetails.getName());
            account.setBalance(accountDetails.getBalance());
            return accountRepository.save(account);
        }
        return null;
    }

    public Account viewAccount(String accountNo) {
        return accountRepository.findByAccountNo(accountNo);
    }

    public void deleteAccount(String accountNo) {
        Account account = accountRepository.findByAccountNo(accountNo);
        if (account != null) {
            accountRepository.delete(account);
        }
    }
}
