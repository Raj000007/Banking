package com.project.staragile.banking;

import com.project.staragile.banking.model.Account;
import com.project.staragile.banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private AccountRepository accountRepository;

    @PostConstruct
    public void init() {
        // Preload some data into the database
        accountRepository.save(new Account(null, "John Doe", 1000.0));
        accountRepository.save(new Account(null, "Jane Smith", 2000.0));
    }
}
