public class BankAccount{
    private static String bankName = "State Bank of India";
    private static int totalAccount = 0;
    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, String accountNumber, double balance){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccount++;
    }

    public static void getTotalAccount(){
        System.out.println("Total number of Accounts: " + totalAccount);
    }

    public void displayAccountDetails(){
        if(this instanceof BankAccount){
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
        }
        else
            System.out.println("Invalid Account instance");
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName){
        this.accountHolderName = accountHolderName;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
        else
            System.out.println("Invalid deposit amount");
    }

    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withrawn: " + amount);
        }
        else
            System.err.println("Insufficient balance"); 
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Ayushi", "789-85469852", 5000.0);
        BankAccount account2 = new BankAccount("Alankrati", "784-54516458", 6000.0);

        System.out.println("Account 1 Details: ");
        account1.displayAccountDetails();
        System.out.println("Account 2 details: ");
        account2.displayAccountDetails();

        BankAccount.getTotalAccount();

        System.out.println("Transactions on account 1: ");
        account1.deposit(1000);
        account1.withdraw(2000);
        account1.displayAccountDetails();
        account2.displayAccountDetails();
        account2.deposit(3000);
        account2.withdraw(1000);
    }
}