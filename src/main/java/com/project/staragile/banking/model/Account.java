package com.project.staragile.banking.model;

import jakarta.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNo;
    
    private String name;
    
    private double balance;

    // Default constructor
    public Account() {
    }

    // Constructor with parameters
    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // Getters and Setters
    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
