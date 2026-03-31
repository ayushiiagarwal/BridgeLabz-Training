import java.util.*;

public class BinaryNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        sc.close();

        ArrayList<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        while(n-- > 0){
            String s1 = queue.poll();
            result.add(s1);

            String s2 = s1;

            if(queue.size() < n){
                queue.add(s1 + "0");
                queue.add(s2 + "1");
            }
        }
        System.out.println(result);
    }
}
