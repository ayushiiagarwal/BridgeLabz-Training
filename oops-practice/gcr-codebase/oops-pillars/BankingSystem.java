interface Loanable{
    void applyForLoan();
    boolean calculateLoanEligibility();
}

abstract class BankAccount{
    String accountNumber;
    String holderName;
    double balance;

    public BankAccount(String accountNumber, String holderName, double balance){
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public void displayDetails(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }

    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount implements Loanable{
    public SavingsAccount(String accountNumber, String holderName, double balance){
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest(){
        return balance * 0.04;
    }

    public void applyForLoan(){
        System.out.println("Loan Applied!");
    }

    public boolean calculateLoanEligibility(){
        return balance > 1000.0;
    }
}

class CurrentAccount extends BankAccount implements Loanable{
    public CurrentAccount(String accountNumber, String holderName, double balance){
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest(){
        return balance * 0.02;
    }

    public void applyForLoan(){
        System.out.println("Loan Applied!");
    }

    public boolean calculateLoanEligibility(){
        return balance > 5000.0;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("SA-4879955", "Olive Smith", 10000.0),
            new CurrentAccount("CA-4584513515", "Liam Hardings", 20000.0)
        };

        for(BankAccount a : accounts){
            a.displayDetails();
            System.out.println("Interest: " + a.calculateInterest());

            if(a instanceof Loanable){
                Loanable loan = (Loanable) a;
                System.out.println(loan.calculateLoanEligibility() ? "Eligible for Loan" : "Not Eligible for Loan");
                loan.applyForLoan();
            }
            System.out.println();

        }

    }
}
