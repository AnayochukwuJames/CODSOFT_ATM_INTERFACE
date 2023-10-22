package com.example.atminterface;

public class ATMServiceImp implements ATMService {
    private final BankAccountService accountService;
    private final BankAccount currentAccount;

    public ATMServiceImp(BankAccountService accountService, BankAccount currentAccount) {
        this.accountService = accountService;
        this.currentAccount = currentAccount;
    }

    private void displayMenu() {
        System.out.println("\nOptions:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    @Override
    public void start() {
        System.out.println("Welcome to the ATM!");

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            if (choice == 1) {
                double depositAmount = getUserAmount("Enter the deposit amount:");
                deposit(depositAmount);
            } else if (choice == 2) {
                double withdrawAmount = getUserAmount("Enter the withdrawal amount:");
                withdraw(withdrawAmount);
            } else if (choice == 3) {
                checkBalance();
            } else if (choice == 4) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    @Override
    public void deposit(double amount) {
        accountService.deposit(currentAccount, amount);
        System.out.println("Deposited $" + amount);
    }
    @Override
    public void withdraw(double amount) {
        if (accountService.checkBalance(currentAccount) >= amount) {
            accountService.withdraw(currentAccount, amount);
            System.out.println("Withdrawn $" + amount);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
    @Override
    public double checkBalance() {
        double balance = accountService.checkBalance(currentAccount);
        System.out.println("Current balance: $" + balance);
        return balance;
    }
    private int getUserChoice() {
        try {
            String userInput = System.console().readLine("Enter your choice: ");
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }
    private double getUserAmount(String prompt) {
        try {
            String userInput = System.console().readLine(prompt);
            return Double.parseDouble(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return -1.0;
        }
    }
}
