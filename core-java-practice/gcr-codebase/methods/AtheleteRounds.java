import java.util.*;
public class AtheleteRounds {

    public static int rounds(int a, int b, int c){
        int distance = 5000;
        int perimeter = a+ b + c;
        int totalRounds = distance / perimeter;

        return totalRounds;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the sides(in meters) of the triangular park: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt(); 

        int result = rounds(a, b, c);
        System.out.println("The number of rounds needed to complete a 5 km run is: " + result);

        sc.close();
    }
}
