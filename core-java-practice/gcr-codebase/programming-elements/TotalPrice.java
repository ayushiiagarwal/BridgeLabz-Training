import java.util.Scanner;
public class TotalPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Unit Price: ");
        int unitPrice = sc.nextInt();

        System.out.println("Enter the quantity to be bought: ");
        int quantity = sc.nextInt();

        int totalPrice = unitPrice * quantity;
        System.out.println("The Total purchase price is INR " + totalPrice + " if the quantity is " + quantity + " and unit price is INR " + unitPrice);
        sc.close();
    }
}
