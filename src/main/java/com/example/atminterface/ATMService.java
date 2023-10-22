package com.example.atminterface;

public interface ATMService {
    void start();
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
}
