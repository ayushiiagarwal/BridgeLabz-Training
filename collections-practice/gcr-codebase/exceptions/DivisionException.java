import java.util.*;
public class DivisionException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.print("Enter numerator: ");
            int numerator = sc.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = sc.nextInt();

            int result = numerator / denominator;
            System.out.println("Result: " + result);

            sc.close();
        }
        catch(ArithmeticException e){
            System.out.println("Cannot divide " + e.getMessage());
        }
        catch(InputMismatchException e){
            System.out.println("Enter Valid Number. " + e.getMessage());
        }
    }
}
