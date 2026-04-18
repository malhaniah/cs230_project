package com.bank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initializing the scanner to read user input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bank System!");
        System.out.println("Please enter your name:");

        // Reads the full line the user types as their name
        String ownerName = scanner.nextLine();
        System.out.println("Hello, " + ownerName + "!");

        System.out.println("Please enter your initial balance:");

        // Reads the user's starting balance as a decimal number
        Double initialBalance = scanner.nextDouble();

        System.out.println("Your initial balance is: " + initialBalance);

        // Keeps the menu running indefinitely until the user chooses to exit
        while (true) {
            System.out.println("Choose an option: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            // Reads the menu option the user selects
            int choice = scanner.nextInt();

            // Routes execution to the correct action based on the user's choice
            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit:");

                    // Reads the deposit amount from the user
                    double depositAmount = scanner.nextDouble();

                    // Updates the balance by calling the deposit method
                    initialBalance = deposit(initialBalance, depositAmount);

                    System.out.println("New balance: " + initialBalance);

                    // Exits the switch so the menu loops again
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");

                    // Reads the withdrawal amount from the user
                    double withdrawAmount = scanner.nextDouble();

                    // Updates the balance by calling the withdraw method
                    initialBalance = withdraw(initialBalance, withdrawAmount);

                    System.out.println("New balance: " + initialBalance);
                    break;
                case 3:
                    System.out.println("*************************************************");

                    // Calls checkBalance and prints the returned value
                    System.out.println("Current balance: " + checkBalance(initialBalance));

                    System.out.println("*************************************************");
                    break;
                case 4:
                    System.out.println("Thank you for using our banking system. Goodbye!");

                    // Releases the scanner resource to free system resources
                    scanner.close();

                    // Exits the main method, terminating the program
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


    public static double deposit(double balance, double amount) {

        // Adds the deposit amount to the current balance
        balance += amount;

        // Returns the updated balance to the caller
        return balance;
    }

    public static double withdraw(double balance, double amount) {

        // Prevents withdrawal if the requested amount exceeds the available balance

        if (amount > balance) {

            System.out.println("Insufficient funds!");

            // Returns the balance unchanged since no withdrawal occurred
            return balance;
        }

        // Deducts the withdrawal amount from the balance
        balance -= amount;

        // Returns the updated balance to the caller
        return balance;
    }

    public static double checkBalance(double balance) {

        // Returns the current balance without modifying it
        return balance;

    }
}