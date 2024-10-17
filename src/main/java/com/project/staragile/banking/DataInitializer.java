package com.project.staragile.banking;

import com.project.staragile.banking.model.Account;
import com.project.staragile.banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {
        // Preload data
        accountRepository.save(new Account(null, "Shubham", 1000.0));
        accountRepository.save(new Account(null, "Aditi", 2000.0));
    }
}
