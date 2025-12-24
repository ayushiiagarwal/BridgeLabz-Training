import java.util.*;
public class SumOfNaturalNumbers {

    public static int naturalSum(int num){
        if(num <= 0) return 0;

        int sum = 0;
        int i = 1;
        while (i <= num) {
            sum += i;
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        int result = naturalSum(num);
        System.out.println("The sum is: " + result);

        sc.close();
    }
}
