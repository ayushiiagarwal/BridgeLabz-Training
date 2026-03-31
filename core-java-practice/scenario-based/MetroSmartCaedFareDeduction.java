import java.util.*;
public class MetroSmartCaedFareDeduction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 100.0;

        System.out.println("Initial balance: " + balance);

        while(balance > 0){
            System.out.println("Enter distance traveled in km or '-1' to exit: ");
            int distance = sc.nextInt();

            if(distance == -1){
                System.out.println("Thank you for travelling!");
                break;
            }
            int fare = (distance <= 20) ? 80 : 100;

            if(balance >= fare){
                balance -= fare;
                System.out.println("fare: " + fare);
                System.out.println("Remaining balance: " + balance);
            }
            else{
                System.out.println("Insufficient balance!");
                System.out.println("Please recharge your card.");
                break;
            }
        }
        System.out.println("Thank you for travelling.");
        
        sc.close();
    }
}
