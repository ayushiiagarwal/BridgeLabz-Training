import java.util.*;
public class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int[] numbers = new int[n];

        System.out.println("Enter 5 numbers: ");
        for(int i=0;i<n;i++){
            numbers[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            if(numbers[i] > 0){
                System.out.println("The number " + numbers[i] + " is positive and " + (numbers[i] % 2 == 0 ? "even" : "odd"));
            }
            else if(numbers[i] < 0)
                System.out.println("The number " + numbers[i] + " is negative.");

            else
                System.out.println("The number is 0.");
        }
            if(numbers[0] > numbers[n-1])
                System.out.println("The first element is greater than the last element.");

            else if(numbers[0] < numbers[n-1])
                System.out.println("The first element is smaller than the last.");

            else
                System.out.println("Both first and last elements are equal.");

        sc.close();
    }
}
