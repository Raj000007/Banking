package com.project.staragile.banking;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.project.staragile.banking.model.Account;
import com.project.staragile.banking.repository.AccountRepository;

@Component
public class DataInitializer {

    @Autowired
    private AccountRepository accountRepository;

    @PostConstruct
    public void init() {
        // Preload some data into the database
        accountRepository.save(new Account("John Doe", 1000.00));
        accountRepository.save(new Account("Jane Smith", 1500.00));
    }
}
