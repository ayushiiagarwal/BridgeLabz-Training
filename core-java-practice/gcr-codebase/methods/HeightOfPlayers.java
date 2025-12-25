import java.util.*;
public class HeightOfPlayers {

    public static int[] getHeights(){
        Random random = new Random();
        int[] heights = new int[11];
        for(int i=0;i<11;i++) 
            heights[i] = 150 + random.nextInt(101); 

        return heights;
    }

    public static int sum(int[] heights){
        int totalSum = 0;
        for(int i : heights)
            totalSum += heights[i];

        return totalSum;
    }

    public static int shortest(int[] heights){
        int min = heights[0];
        for(int i:heights)
            min = Math.min(min, i);

        return min;
    }

    public static int tallest(int[] heights){
        int max = heights[0];
        for(int i:heights)
            max = Math.max(max, i);

        return max;
    }

    public static void main(String[] args) {
        int[] heights = getHeights();

        System.out.println("Mean Height: " + (double)sum(heights)/heights.length);
        System.out.println("Shortest: " + shortest(heights));
        System.out.println("Tallest: " + tallest(heights));
    }
}
