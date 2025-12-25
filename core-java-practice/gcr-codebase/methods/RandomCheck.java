import java.util.*;
public class RandomCheck {

    public static int[] generateRandomArray(int size){
        Random rand = new Random();
        int[] array = new int[size];
        for(int i=0;i<size;i++)
            array[i] = 1000 + rand.nextInt(9000);

        return array;
    }

    public static double[] findAverageMinMax(int[] numbers){
        int sum = 0, min = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for(int num : numbers){
            sum += num;
            min = Math.min(min, num);
            max = Math.max(min, num);
        }
        double average = (double) sum / numbers.length;
        return new double[]{average, min, max};
    }
    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(5);
        
        double[] result = findAverageMinMax(randomArray);
        System.out.println("Average: " + result[0]);
        System.out.println("Minimun: " + randomArray[1]);
        System.out.println("Maximun: " + randomArray[2]);

    }
}
