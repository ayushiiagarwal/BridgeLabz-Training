class Transaction implements Runnable{
    private BankingSystem account;
    private String name;
    private int amount;

    public Transaction(BankingSystem account, String name, int amount){
        this.account = account;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void run(){
        account.withdraw(name, amount);
    }
}

public class BankingSystem extends Thread{
    private int balance = 10000;

    public synchronized boolean withdraw(String name, int amount){
        if(balance >= amount){
            System.out.println(Thread.currentThread().getName() + " is withdrawing: " + amount);
            try{
                Thread.sleep(20);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. \nBalance: " + balance + "\n");
            return true;
        }
        else{
            System.out.println(Thread.currentThread().getName() + " - Insufficient Balance!");
            return false;
        }
    }

    public int getBalance(){ return balance; }

    public static void main(String[] args) throws InterruptedException{
        BankingSystem account = new BankingSystem();

        Thread t1 = new Thread(new Transaction(account, "Adam", 2000), "Adam");
        Thread t2 = new Thread(new Transaction(account, "Liam", 4000), "Liam");

        t1.start();
        t2.start();
    }
}
