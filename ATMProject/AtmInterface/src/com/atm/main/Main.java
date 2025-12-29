package com.atm.main;

// These imports connect the two packages
import com.atm.entity.AtmService;
import com.atm.entity.BankAccount;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AtmService service = new AtmService();
        BankAccount userAccount = new BankAccount();

        System.out.println("\n*** WELCOME TO ATM INTERFACE ***");
        System.out.println("1. Register\n2. Exit");
        int choice = sc.nextInt();

        if (choice == 1) {
            service.register(userAccount);
            boolean loggedIn = false;
            while (!loggedIn) {
                loggedIn = service.login(userAccount);
            }

            boolean isFinished = false;
            while (!isFinished) {
                System.out.println("\n1.Withdraw 2.Deposit 3.Transfer 4.Balance 5.History 6.Exit");
                System.out.print("Choose an option: ");
                int action = sc.nextInt();
                switch (action) {
                    case 1: service.withdraw(userAccount); break;
                    case 2: service.deposit(userAccount); break;
                    case 3: service.transfer(userAccount); break;
                    case 4: System.out.println("Current Balance: " + userAccount.balance + " Rs"); break;
                    case 5: 
                        System.out.println("\n--- Transaction History ---");
                        System.out.println(userAccount.transactionHistory); 
                        break;
                    case 6: isFinished = true; break;
                    default: System.out.println("Invalid Option. Try again.");
                }
            }
        }
        System.out.println("\nThank you for using the ATM, " + userAccount.name + "!");
        sc.close();
    }
}