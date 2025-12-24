import java.util.*;
public class NumberCheck {

    public static int check(int number){
        if(number > 0) return 1;
        else if(number < 0) return -1;
        else return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENter a number: ");
        int number = sc.nextInt();

        int result = check(number);

        System.out.println(result);
        
        sc.close();
    }
}
