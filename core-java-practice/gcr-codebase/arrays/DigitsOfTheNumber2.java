import java.util.*;
public class DigitsOfTheNumber2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int maxDigit = 10;
        int[] array = new int[maxDigit];
        int index = 0;

        while (number != 0 && index < maxDigit) {
            array[index] = number % 10;
            number /= 10;
            index++;
        }

        if (index == maxDigit) {
            int[] tempArray = new int[maxDigit + 10];
            for (int i = 0; i < maxDigit; i++) {
                tempArray[i] = array[i];
            }
            array = tempArray;
            maxDigit += 10;
        }

        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < index; i++) {
            if (array[i] > largest) {
                secondLargest = largest;
                largest = array[i];
            } else if (array[i] > secondLargest && array[i] != largest) {
                secondLargest = array[i];
            }
        }

        System.out.println("Largest digit: " + largest);
        System.out.println("Second Largest digit: " + secondLargest);

        sc.close();
    }
}
