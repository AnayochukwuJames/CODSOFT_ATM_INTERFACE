package com.example.atminterface;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private String accountType;
    private String BankName;
    private double balance;
    private Date accountCreationDate;
}
