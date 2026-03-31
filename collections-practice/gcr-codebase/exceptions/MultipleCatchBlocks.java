import java.util.*;
public class MultipleCatchBlocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try{
            System.out.print("Size of Array: ");
            int n = sc.nextInt();

            int[] array = new int[n];
            System.out.println("Array elements: ");
            for(int i=0;i<n;i++)
                array[i] = sc.nextInt();

            System.out.print("Enter an index: ");
            int idx = sc.nextInt();

            System.out.println("Value at index " + idx + ": " + array[idx]);

            sc.close();
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Index! " + e.getMessage());
        }
        catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
