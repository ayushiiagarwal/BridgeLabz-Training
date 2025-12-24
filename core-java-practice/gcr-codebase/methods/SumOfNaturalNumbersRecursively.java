import java.util.*;
public class SumOfNaturalNumbersRecursively {

    public static int usingRecursion(int num){
        if(num <= 1) return num;

        return num + usingRecursion(num-1);
    }

    public static int usingFormula(int num){
        return num * (num + 1) / 2;
    }

    public static boolean compare(int naturalSum, int sumOfNumbers){
        if(naturalSum == sumOfNumbers)
            return true;
        
        else return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();

        if(number <= 0)
            System.out.println("Enter positive numbers only.");

        int naturalSum = usingRecursion(number);
        System.out.println("The sum of numbers using formula is: " + naturalSum);

        int sumOfNumbers = usingFormula(number);
        System.out.println("The sum of numbers using formula is: " + sumOfNumbers);

        boolean equal = compare(naturalSum, sumOfNumbers);
        System.out.println("Are both sums equal? " + equal);

        sc.close();
    }
}
