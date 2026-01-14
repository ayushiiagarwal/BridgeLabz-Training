import java.util.*;

public class CheckPair {
    public static void main(String[] args) {
        int target = 30;
        int[] arr = {10, 20, 45, 48, 12};

        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num)) {
                System.out.println("Yes");
                return;
            }
            set.add(num);
        }
        System.out.println("No");
    }
}