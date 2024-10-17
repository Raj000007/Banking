package com.project.staragile.banking.repository;

import com.project.staragile.banking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountNo(String accountNo);
}
