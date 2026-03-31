import java.util.HashMap;

public class LongestConsecutive {

    public static int longestConsecutive(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, true);
        }

        int maxLength = 0;

        for (int num : arr) {

            if (!map.containsKey(num - 1)) {

                int currentNum = num;
                int count = 1;

                while (map.containsKey(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                maxLength = Math.max(maxLength, count);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};

        System.out.println("Length of longest consecutive sequence: " + longestConsecutive(arr));
    }
}
