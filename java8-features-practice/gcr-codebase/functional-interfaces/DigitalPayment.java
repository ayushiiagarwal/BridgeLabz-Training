interface Payment{
    void pay();
}

class UPI implements Payment{
    @Override
    public void pay(){
        System.out.println("Paid via UPI!");
    }
}

class Card implements Payment{
    @Override
    public void pay(){
        System.out.println("Paid via Credit Card!");
    }
}

class Wallet implements Payment{
    @Override
    public void pay(){
        System.out.println("Paid via Wallet!");
    }
}

public class DigitalPayment {
    public static void main(String[] args) {
        Payment upi = new UPI();
        Payment card = new Card();
        Payment wallet = new Wallet();

        upi.pay();
        System.out.println();
        card.pay();
        System.out.println();
        wallet.pay();
    }
}
