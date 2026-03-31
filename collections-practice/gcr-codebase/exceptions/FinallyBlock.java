import java.util.*;
public class FinallyBlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.print("Enter two numbers: ");
            int a = sc.nextInt(), b = sc.nextInt();

            int result = a/b;
            System.out.println("Result: " + result);

            sc.close();
        }
        catch(ArithmeticException e){
            System.out.println("Cannot " + e.getMessage());
        }
        finally{
            System.out.println("Operation Completed.");
        }
    }
}
