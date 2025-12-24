import java.util.*;
public class SmallestAndLargest {

    public static void findNumber(int num1, int num2, int num3){
        int largest = num1;
        if(num2 > largest) largest = num2;
        if(num3 > largest) largest = num3;

        int smallest = num1;
        if(num2 < smallest) smallest = num2;
        if(num3 < smallest) smallest = num3;

        System.out.println("Largest Number: " + largest);
        System.out.println("Smallest Number: " + smallest);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        findNumber(num1, num2, num3);

        sc.close();
    }
}
