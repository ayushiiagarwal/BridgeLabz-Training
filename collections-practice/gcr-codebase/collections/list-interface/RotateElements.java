import java.util.*;
public class RotateElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size of list: ");
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Enter List: ");
        for(int i=0; i<n;i++){
            list.add(sc.nextInt());
        }

        System.out.println("Enter rotation value: ");
        int k = sc.nextInt(); // rotate by k

        sc.close();
        
        ArrayList<Integer> temp = new ArrayList<>();

        for( int i=0;i<k;i++){
            temp.add(list.get(i));
        }

        for(int i=k;i<n;i++){
            list.set(i - k, list.get(i));
        }
        
        for (int i = 0; i < temp.size(); i++) {
            list.set(n - k + i, temp.get(i));
        }

        System.out.println("Rotated list: " + list);
    }
}
