import java.util.Scanner;
public class DiscountedStudentFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the fee amount: ");
        int fee = sc.nextInt();

        System.out.println("Enter the Discount Percent: ");
        int discountPercent = sc.nextInt();

        int discount = (fee * discountPercent) / 100;
        int finalFee = fee - discount;

        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);
        
        sc.close();
    }
}
