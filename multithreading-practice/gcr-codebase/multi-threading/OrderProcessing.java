class Chef extends Thread{
    private String dish;
    private int duration;

    public Chef(String name, String dish, int duration){
        super(name);
        this.dish = dish;
        this.duration = duration;
    }

    @Override
    public void run(){
        System.out.println(getName() + " started preparing " + dish);

        try{
            int time = duration/4;

            for(int i=25;i<=100;i+=25){
                Thread.sleep(time);
                System.out.println(getName() + " preparing " + dish + ": " + i + "% completed.");
            }
        }
        catch(InterruptedException e){
            System.out.println(getName() + " interrupted.");
        }
    }
}

public class OrderProcessing {
    public static void main(String[] args) throws InterruptedException{
        Chef chef1 = new Chef("Chef-1", "Pizza", 5000);
        Chef chef2 = new Chef("Chef-2", "Pasta", 2000);
        Chef chef3 = new Chef("Chef-3", "Salad", 3000);

        chef1.start();
        chef2.start();
        chef3.start();

        chef1.join();
        chef2.join();
        chef3.join();

        System.out.println("\nKitchen Closed - All Orders Completed!");

    }
}
