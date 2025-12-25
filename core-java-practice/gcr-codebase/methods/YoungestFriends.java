import java.util.*;
public class YoungestFriends {

    public static int youngestFriend(int[] ages){
        int minAge = ages[0];
        for(int i=0;i<ages.length;i++){
            if(ages[i] < minAge)
                minAge = ages[i];
        }
        return minAge;
    }

    public static int tallestFriend(int[] heights){
        int maxHeight = heights[0];
        for(int i=0;i<heights.length;i++){
            if(heights[i] > maxHeight)
                maxHeight = heights[i];
        }
        return maxHeight;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ages of the 3 friends, 'Amar', 'Akbar', 'Anthony': ");
        int[] ages = new int[3];
        for(int i=0;i<ages.length;i++){
            ages[i] = sc.nextInt();
        }

        System.out.println("Enter the heights of the 3 friends, 'Amar', 'Akbar', 'Anthony': ");
        int[] heights = new int[3];
        for(int i=0;i<heights.length;i++){
            heights[i] = sc.nextInt();
        }

        int youngest = youngestFriend(ages);
        System.out.println("The youngest friend is: " + youngest);

        int tallest = tallestFriend(heights);
        System.out.println("The tallest friend is: " + tallest);

        sc.close();
    }
}
