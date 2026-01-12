import java.util.ArrayList;
import java.util.List;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public double getAmount(){
        return amount;
    }

    @Override
    public String toString() {
        return type + ": " + amount;
    }
}

class DigitalWallet {
    private double balance;
    private List<Transaction> history;

    public DigitalWallet() {
        this.balance = 0.0;
        this.history = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        history.add(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance!\nCurrent: " + balance);
        }
        balance -= amount;
        history.add(new Transaction("Withdrawal", amount));
    }

    public double getBalance() { 
        return balance; 
    }

    public void showHistory() {
        System.out.println("--- Transaction History ---");
        for (Transaction t : history) {
            System.out.println(t);
        }
        System.out.println("Current Balance: " + balance);
    }
}

class WalletUser {
    private String name;
    private DigitalWallet wallet;

    public WalletUser(String name) {
        this.name = name;
        this.wallet = new DigitalWallet();
    }

    public String getName() { 
        return name; 
    }
    public DigitalWallet getWallet() { 
        return wallet; 
    }
}

interface TransferService {
    void transfer(WalletUser sender, double amount) throws InsufficientBalanceException;
}

class WalletTransfer implements TransferService {
    private WalletUser receiver;

    public WalletTransfer(WalletUser receiver) {
        this.receiver = receiver;
    }

    @Override
    public void transfer(WalletUser sender, double amount) throws InsufficientBalanceException {
        sender.getWallet().withdraw(amount); 
        receiver.getWallet().deposit(amount); 
        System.out.println("Transferred " + amount + " to " + receiver.getName());
    }
}

class BankTransfer implements TransferService {
    private String bankAccount;

    public BankTransfer(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void transfer(WalletUser sender, double amount) throws InsufficientBalanceException {
        sender.getWallet().withdraw(amount);
        System.out.println("Transferred " + amount + " to Bank Account: " + bankAccount);
    }
}

public class DigitalWalletSystem {
    public static void main(String[] args) {
        WalletUser user1 = new WalletUser("Adam");
        WalletUser user2 = new WalletUser("Jack");

        user1.getWallet().deposit(500.0);
        System.out.println("Amount Deposited \nBalance: " + user1.getWallet().getBalance());
        System.out.println();
        

        try {
            TransferService walletToWallet = new WalletTransfer(user2);
            walletToWallet.transfer(user1, 200.0);

            TransferService walletToBank = new BankTransfer("ABCD-9876");
            walletToBank.transfer(user1, 100.0);

            System.out.println("\nAttempting to transfer more than balance...");
            walletToWallet.transfer(user1, 1000.0);

        } catch (InsufficientBalanceException e) {
            System.err.println(e.getMessage());
        }

        System.out.println();
        user1.getWallet().showHistory();
        System.out.println();
        user2.getWallet().showHistory();
    }
}
