import java.util.*;
public class CoffeeCounterChronicles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean coffee = true;
        while(coffee) {
            System.out.println("====== The Coffee Counter Chronicles ======");
            System.out.println("============ Menu =============");
            System.out.println("1. Espresso     -   Rs. 100/-");
            System.out.println("2. Latte        -   Rs. 120/-");
            System.out.println("3. Cappuccino   -   Rs. 150/-");
            System.out.println("4. Americano    -   Rs. 130/-");
            System.out.println("5. Mocha        -   Rs. 200/-");
            System.out.println("Enter coffee type or type 'exit' to quit:");

            String coffeeType = sc.nextLine();

            if(coffeeType.equalsIgnoreCase("exit")) {
                System.out.println("Have a great day!");
                break;
            }

            double price = 0.0;
            switch (coffeeType) {
                case "espresso":
                    price = 100.0;
                    break;
                case "latte":
                    price = 120.0;
                    break;
                case "cappuccino":
                    price = 150.0;
                    break;
                case "americano":
                    price = 130.0;
                    break;
                case "mocha":
                    price = 200.0;
                    break;
                default:
                    System.out.println("Invalid coffee type. Please try again.");
            }

            System.out.println("Enter quantity:");
            int quantity = sc.nextInt();
            sc.nextLine(); // Consume newline

            double totalBill = price * quantity;
            double gst = totalBill * 0.05; 
            double finalAmount = totalBill + gst;

            System.out.println("======= Bill Details =======");
            System.out.println("Coffee Type:                    " + coffeeType);
            System.out.println("Quantity:                       " + quantity);
            System.out.println("Amount:                     Rs. " + totalBill);
            System.out.println("GST (5%):                   Rs. " + gst);
            System.out.printf("Total bill (including GST): Rs. %.2f%n       ", finalAmount);
        }

        sc.close();
    }
}