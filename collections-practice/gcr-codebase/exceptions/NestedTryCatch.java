public class NestedTryCatch {
    public static void main(String[] args) {
        int[] arr = {100, 200, 300};
        int idx = 2;
        int divisor = 0;

        try {
            try {
                int result = arr[idx] / divisor;
                System.out.println(result);
            }
            catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}