// Search for the first Negative Number

import java.util.*;
public class FirstNegative {

    public static int searchNumber(int[] numbers){
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] < 0){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];
        System.out.println("Enter the elements od the array: ");
        for(int i=0;i<n;i++){
            numbers[i] = sc.nextInt();
        }

        sc.close();
        
        int result = searchNumber(numbers);
        System.out.println("First Negative Number found at index: " + result);
    }
}
