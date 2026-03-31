import java.util.*;
public class Chocolates {

    public static void remainingChocolates(int chocolates, int children){
        int chocolatePerChildren = chocolates / children;
        System.out.println("Chocolate per Children: " + chocolatePerChildren);

        int remaining = chocolates % children;
        System.out.println("Remaining Chocolates: " + remaining);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of chocolates: ");
        int chocolates = sc.nextInt();

        System.out.println("Enter number of children: ");
        int children = sc.nextInt();

        remainingChocolates(chocolates, children);

        sc.close();
    }
}
