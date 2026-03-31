import java.util.Scanner;
public class FitnessChallengeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] pushUps = new int[7];

        int totalPushUps = 0;
        int averagePushUps = 0;
        
        for (int i=0; i<7;i++) {
            System.out.println("Enter push-ups for day " + (i+1) + ": ");
            int count = sc.nextInt();
            pushUps[i] = count;

            if (count == 0) {
                System.out.println("Rest day!");
                continue;
            }

            totalPushUps += count;
        }
        averagePushUps = totalPushUps / 7;

        System.out.println("Total push-ups in the week: " + totalPushUps);

        System.out.println("Average push-ups per day: " + averagePushUps);

        sc.close();
    }
}
