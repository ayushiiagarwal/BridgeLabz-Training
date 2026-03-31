import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

interface BankService {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    void calculateInterest();
}

class FundTransferTask implements Runnable {
    private Account from;
    private Account to;
    private double amount;

    public FundTransferTask(Account from, Account to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            synchronized (from) {
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println(Thread.currentThread().getName() + " transferred " + amount);
            }
        } catch (InsufficientBalanceException e) {
            System.out.println(Thread.currentThread().getName() + e.getMessage());
        }
    }
}

abstract class Account implements BankService {
    protected String accountNumber;
    protected double balance;
    protected List<String> history = new ArrayList<>();

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        history.add("Deposited: " + amount);
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Balance too low: " + balance);
        }
        balance -= amount;
        history.add("Withdrew: " + amount);
    }

    public double getBalance() { 
        return balance; 
    }
    public void showHistory() { 
        System.out.println("Transaction History for " + accountNumber + ":");
    
        if (history.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (String record : history) {
                System.out.println(record);
            }
        }
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, double balance) { 
        super(accountNumber, balance); 
    }

    @Override
    public void calculateInterest() {
        double interest = balance * 0.05; 
        deposit(interest);
        System.out.println("Savings Interest Added: " + interest);
    }
}

public class OnlineBanking {
    public static void main(String[] args) {
        Account acc1 = new SavingsAccount("SA101", 5000);
        Account acc2 = new SavingsAccount("SA102", 3000);

        Thread t1 = new Thread(new FundTransferTask(acc1, acc2, 2000), "ATM-Transfer");
        Thread t2 = new Thread(new FundTransferTask(acc1, acc2, 4000), "Mobile-App-Transfer");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("\nFinal Balance for Account 1: " + acc1.getBalance());
        acc1.showHistory();
    }
}