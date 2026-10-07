import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();

        // Sample account for testing
        accounts.put(
            "user123",
            new Account("user123", "1234", 10000.00)
        );
    }

    public Account getAccount(String userId) {
        return accounts.get(userId);
    }

    public boolean authenticate(String userId, String pin) {
        Account account = accounts.get(userId);

        if (account == null) {
            return false;
        }

        return account.verifyPin(pin);
    }
}
