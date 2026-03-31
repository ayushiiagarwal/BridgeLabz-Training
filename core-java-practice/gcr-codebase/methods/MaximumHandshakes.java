import java.util.*;
public class MaximumHandshakes {

    public static int maxHandshakes(int n){
        int handshakes = (n * (n-1)) / 2;

        return handshakes;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();

        int result = maxHandshakes(n);

        System.out.println("The number of possible handshakes for " + n + " students is " + result);

        sc.close();
    }
}
