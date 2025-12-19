// check if the first is smallest of the 3 numbers

import java.util.Scanner;
public class FirstIsSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int num1 = sc.nextInt();

        System.out.println("Enter the second number: ");
        int num2 = sc.nextInt();

        System.out.println("Enter the third number: ");
        int num3 = sc.nextInt();

        if(num1 < num2 && num1 < num3){
            System.out.println("Is the first number smallest? Yes");

        }
        else{
            System.out.println("Is the first number smallest? No");
        }
        sc.close();
    }
}
