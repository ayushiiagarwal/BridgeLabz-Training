//find the maximum number of handshakes
import java.util.Scanner;
public class NumberOfHandshakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n = sc.nextInt(); //number of students

        int handshakes = (n*(n-1))/2;

        System.out.println("The number of possible handshakes is " + handshakes);
        sc.close();
    }
}
