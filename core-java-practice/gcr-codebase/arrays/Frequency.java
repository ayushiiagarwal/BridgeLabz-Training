import java.util.Scanner;
public class Frequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[] frequency = new int[10];

        while (number != 0) {
            int count = number % 10;
            frequency[count]++;
            number /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + " " + frequency[i]);
            }
        }
        sc.close();
    }    
}
