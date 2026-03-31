class InsufficientBalance extends Exception{
    InsufficientBalance(String message){
        super(message);
    }
}

class Account{
    double balance = 5000.0;

    void withdraw(double amount) throws InsufficientBalance{
        if(amount < 0)
            throw new IllegalArgumentException("Invalid Amount!");

        if(amount > balance)
            throw new InsufficientBalance("Insufficient Balance!");

        balance -= amount;
        System.out.println("Withdrawal Successful! \nBalance: " + balance);
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        Account acc = new Account();

        try{
            acc.withdraw(6000.0);
        }
        catch(InsufficientBalance e){
            System.out.println(e.getMessage());
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
