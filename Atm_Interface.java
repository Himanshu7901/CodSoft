package Task3;

import java.util.Scanner;

public class Atm_Interface {

    class BankAccount {
        private double balance;

        // Constructor to initialize the account balance
        public BankAccount(double initialBalance) {
            balance = initialBalance;
        }

        // Method to get the account balance
        public double getBalance() {
            return balance;
        }

        // Method to deposit money into the account
        public void deposit(double amount) {
            balance += amount;
        }

        // Method to withdraw money from the account (returns true if successful, false
        // if insufficient balance)
        public boolean withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        }
    }

    class ATM {
        private BankAccount account;

        // Constructor to associate an ATM with a bank account
        public ATM(BankAccount account) {
            this.account = account;
        }

        // Display the ATM menu
        public void displayMenu() {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
        }

        // Run the ATM program
        public void run() {
            Scanner scanner = new Scanner(System.in);
            boolean isRunning = true;

            while (isRunning) {
                displayMenu();
                System.out.print("Select an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Account Balance: $" + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter the deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        System.out.println("Deposited $" + depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter the withdrawal amount: $");
                        double withdrawAmount = scanner.nextDouble();
                        if (account.withdraw(withdrawAmount)) {
                            System.out.println("Withdrawn $" + withdrawAmount);
                        } else {
                            System.out.println("Insufficient balance. Withdrawal failed.");
                        }
                        break;
                    case 4:
                        isRunning = false;
                        System.out.println("Thank you for using the ATM.");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a valid option.");
                }
            }
        }
    }

    public class Main {
        public static void main(String[] args) {
            BankAccount userAccount = new BankAccount(1000); // Initial account balance
            ATM atm = new ATM(userAccount);
            atm.run();
        }
    }

}
