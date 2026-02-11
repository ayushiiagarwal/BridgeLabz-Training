public class Program {
    double balance;

    public Program(double balance){
        this.balance = balance;
    }

    public void Deposit(double amount){
        if(amount < 0)
            throw new RuntimeException("Deposit amount must be more than 0.");

        balance += amount;
    }

    public void Withdraw(double amount){
        if(amount > balance)
            throw new RuntimeException("Insufficient Funds!");

        balance -= amount;
    }
}
