package com.example.atminterface;

public interface BankAccountService {
    void deposit(BankAccount account, double amount);
    void withdraw(BankAccount account, double amount);
    double checkBalance(BankAccount account);
}
