package com.atm.entity;

import java.util.Scanner;

public class AtmService {
    private Scanner sc = new Scanner(System.in);

    public void register(BankAccount acc) {
        System.out.println("\nEnter Your Name:");
        acc.name = sc.nextLine();
        System.out.println("Enter Your Username:");
        acc.userName = sc.nextLine();
        System.out.println("Enter Your Password:");
        acc.password = sc.nextLine();
        System.out.println("Enter Your Account Number:");
        acc.accountNo = sc.nextLine();
        System.out.println("\nRegistration Successful. Please Log in.");
    }

    public boolean login(BankAccount acc) {
        System.out.println("\nEnter Your UserName: ");
        String inputUser = sc.nextLine();
        if (inputUser.equals(acc.userName)) {
            System.out.println("Enter Your Password: ");
            String inputPass = sc.nextLine();
            if (inputPass.equals(acc.password)) {
                System.out.println("\nLogin Successful!");
                return true;
            }
        }
        System.out.println("\nInvalid Credentials.");
        return false;
    }

    public void withdraw(BankAccount acc) {
        System.out.print("\nEnter Amount To Withdraw: ");
        float amount = sc.nextFloat();
        if (acc.balance >= amount) {
            acc.balance -= amount;
            acc.transactions++;
            acc.transactionHistory += amount + " Rs Withdrawn\n";
            System.out.println("Withdraw Successful.");
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    public void deposit(BankAccount acc) {
        System.out.print("\nEnter Amount To Deposit (Limit 10k): ");
        float amount = sc.nextFloat();
        if (amount <= 10000) {
            acc.balance += amount;
            acc.transactions++;
            acc.transactionHistory += amount + " Rs Deposited\n";
            System.out.println("Deposit Successful.");
        } else {
            System.out.println("Deposit Limit Exceeded.");
        }
    }

    public void transfer(BankAccount acc) {
        sc.nextLine(); // Clear buffer
        System.out.print("\nEnter Recipient's Name: ");
        String recipient = sc.nextLine();
        System.out.print("Enter Amount To Transfer: ");
        float amount = sc.nextFloat();
        if (acc.balance >= amount && amount <= 50000) {
            acc.balance -= amount;
            acc.transactions++;
            acc.transactionHistory += amount + " Rs Transferred to " + recipient + "\n";
            System.out.println("Transfer Successful.");
        } else {
            System.out.println("Transfer Failed (Check Balance/Limit).");
        }
    }
}