package com.project.staragile.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    private String accountNo; // Assuming accountNo is a String based on your earlier messages.

    private String name;
    private Double balance;

    // Default constructor
    public Account() {}

    // Parameterized constructor
    public Account(String accountNo, String name, Double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    // Getters and Setters
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
