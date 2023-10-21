package com.example.atminterface;

public interface ATMService {
   public void start();
    public void deposit(double amount);
    public void withdraw(double amount);
    double checkBalance();
}
