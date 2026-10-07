import java.util.ArrayList;
import java.util.List;

public class Account {

    private String userId;
    private String pin;
    private double balance;
    private List<Transaction> transactions;

    public Account(String userId, String pin, double initialBalance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public boolean verifyPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }

        balance += amount;
        transactions.add(
            new Transaction("Deposit", amount)
        );

        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        transactions.add(
            new Transaction("Withdrawal", amount)
        );

        return true;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
