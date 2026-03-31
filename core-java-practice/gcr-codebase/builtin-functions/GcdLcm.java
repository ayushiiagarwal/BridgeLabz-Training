import java.util.Scanner;
public class GcdLcm {

    public static int findGCD(int num1, int num2){
        while(num2 != 0){
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static int findLCM(int num1, int num2, int gcd){
        return (num1 * num2) / gcd;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int gcd = findGCD(num1, num2);
        int lcm = findLCM(num1, num2, gcd);

        System.out.println(gcd + " " + lcm);

        sc.close();
    }
}
