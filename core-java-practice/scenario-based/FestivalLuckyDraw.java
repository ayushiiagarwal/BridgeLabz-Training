// At Diwali mela, each visitor draws a number.
// ● If the number is divisible by 3 and 5, they win a gift.
// ● Use if, modulus, and loop for multiple visitors.
// ● continue if input is invalid.

import java.util.Scanner;
public class FestivalLuckyDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Enter a number: ");
            int number = sc.nextInt();

            if (number % 3 == 0 && number % 5 == 0)
                System.out.println("Congratulations! You win a gift.");
            else 
                System.out.println("Better luck next time.");

            System.out.println("Next visitor? (yes/no)");
            String response = sc.next();

            if (response.equalsIgnoreCase("no")) 
                break;

            System.out.println("Exited!");
        }    
        sc.close();
    }
}
