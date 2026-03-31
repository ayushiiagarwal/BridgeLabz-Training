class BankAccount{
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount{
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Savings Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + interestRate + "\n");
    }
}

class CheckingAccount extends BankAccount{
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double limit) {
        super(accountNumber, balance);
        this.withdrawalLimit = limit;
    }

    void displayAccountType() {
        System.out.println("Checking Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Withdrawal Limit: " + withdrawalLimit + "\n");
    }
}

class FixedDepositAccount extends BankAccount{
    int termInMonths;

    FixedDepositAccount(String accountNumber, double balance, int termInMonths) {
        super(accountNumber, balance);
        this.termInMonths = termInMonths;
    }

    void displayAccountType() {
        System.out.println("Fixed Deposit Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Months: " + termInMonths + "\n");
    }
}

public class BankAccountTypes {
    public static void main(String[] args) {
        SavingsAccount type1 = new SavingsAccount("SA123", 50000, 3.5);
        type1.displayAccountType();

        CheckingAccount type2 = new CheckingAccount("CA123", 30000, 20000);
        type2.displayAccountType();

        FixedDepositAccount type3 = new FixedDepositAccount("FD123", 100000, 12);
        type3.displayAccountType();
        
    }
}
