package com.project.staragile.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts") // Specify the table name
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use the appropriate strategy
    private Long accountNo; // Primary key

    private String name; // Account holder name
    private double balance; // Account balance

    // Default constructor
    public Account() {}

    // Parameterized constructor
    public Account(Long accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    // Getters and setters
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

    // Other methods if needed...
}
