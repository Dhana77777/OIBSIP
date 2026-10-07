import java.util.List;
import java.util.Scanner;

public class ATM {

    private Bank bank;
    private Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        System.out.println("==============================");
        System.out.println("        ATM INTERFACE");
        System.out.println("==============================");

        Account account = login();

        if (account == null) {
            System.out.println("Too many failed attempts.");
            System.out.println("Account locked. Exiting...");
            return;
        }

        System.out.println("\nLogin successful!");
        System.out.println("Welcome, " + account.getUserId() + "!");

        showMenu(account);
    }

    private Account login() {

        int attempts = 0;
        int maxAttempts = 3;

        while (attempts < maxAttempts) {

            System.out.print("\nEnter User ID: ");
            String userId = scanner.nextLine();

            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            if (bank.authenticate(userId, pin)) {
                return bank.getAccount(userId);
            }

            attempts++;

            System.out.println("Invalid User ID or PIN.");
            System.out.println("Attempts remaining: "
                    + (maxAttempts - attempts));
        }

        return null;
    }

    private void showMenu(Account account) {

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println("          ATM MENU");
            System.out.println("==============================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    checkBalance(account);
                    break;

                case 2:
                    deposit(account);
                    break;

                case 3:
                    withdraw(account);
                    break;

                case 4:
                    transfer(account);
                    break;

                case 5:
                    showTransactionHistory(account);
                    break;

                case 6:
                    System.out.println("\nThank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);
    }

    private void checkBalance(Account account) {

        System.out.printf(
                "\nCurrent Balance: ₹%.2f%n",
                account.getBalance()
        );
    }

    private void deposit(Account account) {

        System.out.print("\nEnter deposit amount: ");

        try {
            double amount = Double.parseDouble(scanner.nextLine());

            if (account.deposit(amount)) {
                System.out.printf(
                        "₹%.2f deposited successfully.%n",
                        amount
                );

                checkBalance(account);
            } else {
                System.out.println(
                        "Invalid amount. Deposit must be greater than zero."
                );
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount.");
        }
    }

    private void withdraw(Account account) {

        System.out.print("\nEnter withdrawal amount: ");

        try {
            double amount = Double.parseDouble(scanner.nextLine());

            if (account.withdraw(amount)) {

                System.out.printf(
                        "₹%.2f withdrawn successfully.%n",
                        amount
                );

                checkBalance(account);

            } else {

                System.out.println(
                        "Invalid amount or insufficient balance."
                );
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount.");
        }
    }

    private void transfer(Account account) {

        System.out.print("\nEnter recipient User ID: ");
        String recipientId = scanner.nextLine();

        Account recipient = bank.getAccount(recipientId);

        if (recipient == null) {
            System.out.println("Recipient account not found.");
            return;
        }

        if (recipient == account) {
            System.out.println("You cannot transfer money to yourself.");
            return;
        }

        System.out.print("Enter transfer amount: ");

        try {
            double amount = Double.parseDouble(scanner.nextLine());

            if (account.withdraw(amount)) {

                recipient.deposit(amount);

                System.out.printf(
                        "₹%.2f transferred successfully to %s.%n",
                        amount,
                        recipientId
                );

                checkBalance(account);

            } else {

                System.out.println(
                        "Transfer failed. Check the amount and balance."
                );
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount.");
        }
    }

    private void showTransactionHistory(Account account) {

        List<Transaction> transactions = account.getTransactions();

        System.out.println("\n==============================");
        System.out.println("     TRANSACTION HISTORY");
        System.out.println("==============================");

        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
