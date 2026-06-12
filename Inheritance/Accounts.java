import java.util.*;

class Account{
    private int accountnumber;
    private String holdername;
    private double balance;

    public Account(int accountnumber, String holdername, double balance){
        this.accountnumber = accountnumber;
        this.holdername = holdername;
        this.balance = balance;
    }

    public int getAccountnumber(){ return accountnumber; }
    public String getHoldername(){ return holdername; }
    public double getBalance(){ return balance; }

     public void display() {
        System.out.println("Acc No: " + accountnumber +
                ", Name: " + holdername +
                ", Balance: " + balance);
     }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accNo, String name, double balance, double rate) {
        super(accNo, name, balance);
        this.interestRate = rate;
    }

    public double calculateYearlyInterest() {
        return getBalance() * interestRate / 100;
    }

    public void display() {
        super.display();
        System.out.println("Type: Savings, Interest: " + calculateYearlyInterest());
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public void display() {
        super.display();
        System.out.println("Type: Current");
    }
}

class Manager {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    public void displayAll() {
        for (Account acc : accounts) {
            acc.display();
            System.out.println("------------------");
        }
    }
}

public class Accounts {
    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.addAccount(new SavingsAccount(1, "A", 10000, 5));
        manager.addAccount(new SavingsAccount(2, "B", 20000, 4));

        manager.addAccount(new CurrentAccount(3, "C", 15000));
        manager.addAccount(new CurrentAccount(4, "D", 25000));
        manager.addAccount(new CurrentAccount(5, "E", 30000));

        manager.displayAll();
    }
}