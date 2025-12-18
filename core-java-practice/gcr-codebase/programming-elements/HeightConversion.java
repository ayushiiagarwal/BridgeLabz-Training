import java.util.Scanner;
public class HeightConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your height in cm: ");
        int height = sc.nextInt(); 
        
        double inches = height / 2.54; // 1 inch = 2.54
        double feet = inches / 12; // 1 foot = 12 inches

        System.out.println("Your height in cm is " + height + " while in feet is " + feet + " and inches is " + inches);
        sc.close();
    }
}
