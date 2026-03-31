abstract class BankAccount{
    private final String accountNumber;
    private final double balance;

    BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    String getAccountNumber(){
        return accountNumber;
    }

    double getBalance(){
        return balance;
    }

    abstract double calculateFee();
}

class SavingAccount extends BankAccount{
    SavingAccount(String accountNumber, double balance){
        super(accountNumber, balance);
    }

    double calculateFee(){
        return getBalance() * 0.005;
    }
}

class CheckingAccount extends BankAccount{
    CheckingAccount(String accountNumber, double balance){
        super(accountNumber, balance);
    }

    double calculateFee(){
        if(getBalance() < 1000) return 1.0;

        return 0.0;
    }
}

public class BankingAccountHierarchy {
    public static void main(String[] args) {
        BankAccount saving1 = new SavingAccount("SA45879", 1000.0);
        System.out.printf("%.2f%n", saving1.calculateFee());

        BankAccount savings2 = new SavingAccount("SA26589", 500.0);
        System.out.printf("%.2f%n", savings2.calculateFee());

        BankAccount checking1 = new CheckingAccount("CA165415", 1500.0);
        System.out.printf("%.2f%n", checking1.calculateFee());

        BankAccount checking2 = new CheckingAccount("CA154154", 500.0);
        System.out.printf("%.2f%n", checking2.calculateFee());
    }
}
