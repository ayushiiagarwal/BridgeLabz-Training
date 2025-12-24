import java.util.*;
public class Factors {

    public static int[] getFactors(int num){
        int count = 0;
        for(int i=1;i<=num;i++){
            if(num % i == 0)
                count++;
        }
        int[] factors = new int[count];
        int index = 0;
        for(int i=1;i<=num;i++){
            if(num % i == 0){
                factors[index] = i;
                index++;
            }
        }
        return factors;
    }

    public static int sumOfFactors(int[] array){
        int sum = 0;
        for(int i : array){
            sum += i;
        }
        return sum;

    }

    public static int sumOfSquares(int[] array){
        int total = 0;
        for(int i : array){
            total += Math.pow(i, 2);
        }
        return total;
    }

    public static int productOfFactors(int[] array){
        int product = 1;
        for(int i : array){
            product *= i;
        }
        return product;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        int[] array = getFactors(num);
        System.out.println("The array are: " + Arrays.toString(array));

        int sum = sumOfFactors(array);
        System.out.println("The sum of the factors is: " +sum);

        int squareSum = sumOfSquares(array);
        System.out.println("The sum of squares of factors is: " + squareSum);

        int product = productOfFactors(array);
        System.out.println("The product of Factors is: " + product);

        sc.close();
    }
}