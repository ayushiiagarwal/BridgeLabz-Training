interface PaymentProcessor{
    void pay(double amount);

    default void refund(double amount){
        System.out.println("Refunding Amount: " + amount);
    }
}

class UPIPayment implements PaymentProcessor{
    @Override
    public void pay(double amount){
        System.out.println("Paid: " + amount + " using UPI.");
    }
}

class CardPayment implements PaymentProcessor{
    @Override
    public void pay(double amount){
        System.out.println("Paid: " + amount + " using card!");
    }
}

public class PaymentGateway {
    public static void main(String[] args) {
        PaymentProcessor payment1 = new UPIPayment();
        PaymentProcessor payment2 = new CardPayment();

        payment1.pay(500);
        payment1.refund(200);
        System.out.println();

        payment2.pay(1000);
        payment2.refund(500);
    }
}
