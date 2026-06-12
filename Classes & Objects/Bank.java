import java.util.ArrayList;

public class Bank {
    static class BankAccount {
        final int AccountNumber;
        float balance;
        String ownerName;

        BankAccount(int AccountNumber, float balance, String ownerName) {
            this.AccountNumber = AccountNumber;
            this.balance = balance;
            this.ownerName = ownerName;
        }

        float balance() {
            return balance;
        }

        void add(float amount) {
            balance += amount;
        }

        void subtract(float amount) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                System.out.println("Insufficient funds for account: " + AccountNumber);
            }
        }
    }

    static class AccountManager {
        ArrayList<BankAccount> accounts = new ArrayList<>();

        void createAccount(int accountNumber, float balance, String ownerName) {
            accounts.add(new BankAccount(accountNumber, balance, ownerName));
        }

        void deleteAccount(int accountNumber) {
            accounts.removeIf(acc -> acc.AccountNumber == accountNumber);
        }

        void debit(int accountNumber, float amount) {
            for (BankAccount acc : accounts) {
                if (acc.AccountNumber == accountNumber) {
                    acc.subtract(amount);
                    return;
                }
            }
            System.out.println("Account not found: " + accountNumber);
        }

        void credit(int accountNumber, float amount) {
            for (BankAccount acc : accounts) {
                if (acc.AccountNumber == accountNumber) {
                    acc.add(amount);
                    return;
                }
            }
            System.out.println("Account not found: " + accountNumber);
        }

        void printAllAccounts() {
            for (BankAccount acc : accounts) {
                System.out.println("Account Number: " + acc.AccountNumber + ", Owner: " + acc.ownerName + ", Balance: " + acc.balance());
            }
        }
    }

    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        manager.createAccount(1001, 500.0f, "Alice");
        manager.createAccount(1002, 1000.0f, "Bob");
        manager.createAccount(1003, 1500.0f, "Charlie");
        manager.createAccount(1004, 2000.0f, "Diana");
        manager.createAccount(1005, 2500.0f, "Evan");

        manager.printAllAccounts();
    }
}
