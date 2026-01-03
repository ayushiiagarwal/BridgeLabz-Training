public class BankAccount {
    int accountNumber;
    double balance;

    BankAccount(int accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Amount Deposited: " + amount);
        }
    }

    public void withdraw(double amount){
        if(amount <= balance && amount > 0){
            balance -= amount;
            System.out.println("Withdraw Amount is: " + amount);
        }
        else
            System.out.println("Insufficient balance");
    }

    public void displayAccountNumber(){
        System.out.println("Account Number: " + accountNumber);
    }

    public void displayBalance(){
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(15548513, 5000.0);
        
        account.displayAccountNumber();
        account.displayBalance();
        account.deposit(2000.0);
        account.displayBalance();
        account.withdraw(7000.0);
        account.displayBalance();
    }
}
