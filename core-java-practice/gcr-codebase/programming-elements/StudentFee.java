//
public class StudentFee {
    public static void main(String[] args) {
        int fee = 125000;
        int discountPercent = 10;
        int discountAmount = (fee * discountPercent) / 100;
        int finalFee = fee - discountAmount;
        System.out.println("The final fee after discount is: " + finalFee);
    }
}
