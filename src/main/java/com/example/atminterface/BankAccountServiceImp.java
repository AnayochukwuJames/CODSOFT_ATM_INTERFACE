package com.example.atminterface;

public class BankAccountServiceImp implements BankAccountService {
    @Override
    public void deposit(BankAccount account, double amount) {
        if (amount > 0) {
            double currentBalance = account.getBalance();
            double newBalance = currentBalance + amount;
            account.setBalance(newBalance);
            System.out.println("Deposit successful. New balance: " + newBalance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }
    @Override
    public void withdraw(BankAccount account, double amount) {
        if (amount > 0) {
            double currentBalance = account.getBalance();
            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                account.setBalance(newBalance);
                System.out.println("Withdrawal successful. New balance: " + newBalance);
            } else {
                System.out.println("Insufficient balance. Withdrawal failed.");
            }
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
        }
    }

    @Override
    public double checkBalance(BankAccount account) {
        double currentBalance = account.getBalance();
        System.out.println("Your current balance is: " + currentBalance);
        return currentBalance;
    }
}
