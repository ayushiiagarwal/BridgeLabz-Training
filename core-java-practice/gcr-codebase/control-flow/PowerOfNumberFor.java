import java.util.Scanner;
public class PowerOfNumberFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number and power: ");
        int num = sc.nextInt(); 
        int power = sc.nextInt();
        if(num > 0 && power > 0){
            int result = 1;
            for(int i=1; i<=power;i++){
                result *= num;
            }
            System.out.println("Result: " + result);
        }
        else System.out.println("Only Positive Numbers");
        
        sc.close();
    }
}
