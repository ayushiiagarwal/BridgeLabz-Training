import java.util.HashMap;

public class CheckPair {

    public static boolean hasPair(int[] arr, int target) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int required = target - arr[i];
            if (map.containsKey(required)) {
                return true;
            }
            map.put(arr[i], true);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;

        if (hasPair(arr, target)) {
            System.out.println("Pair exists");
        } else {
            System.out.println("Pair does not exist");
        }
    }
}
