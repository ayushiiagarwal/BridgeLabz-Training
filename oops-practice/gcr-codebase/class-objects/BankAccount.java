public class BankAccount {
    String accountHolder, accountNumber;
    double balance;

    BankAccount(String accountHolder, String accountNumber, double balance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;

    }

    public static void displayBank(){
        System.out.println("Bank of India");
    }

    public void displayBalance(){
        System.out.println("Current Balance: " + balance);
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
        else
            System.out.println("Amount must be positive");

    }

    public void withdraw(double amount){
        if(amount <= balance && amount > 0){
            balance -= amount;
            System.out.println("Withdraw Amount is: " + amount);
        }
        else
            System.out.println("Insufficient balance");
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Ayushi", "1234567890315", 10000.0);

        displayBank();

        account.displayBalance();
        account.deposit(2000.0);
        account.displayBalance();
        account.withdraw(3000.0);
        account.displayBalance();
        account.withdraw(10000.0);
    }
}
