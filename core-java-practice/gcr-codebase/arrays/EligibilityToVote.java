import java.util.*;
public class EligibilityToVote{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 10;
        int[] ages = new int[n];
        System.out.println("Enter the ages of 10 students: ");
        for(int i=0;i<n;i++){
            ages[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            if(ages[i]<0){
                System.out.println("Invalid age");
            } else if(ages[i]>=18){
                System.out.println("The student with the age " + ages[i] + " can vote.");
            } else {
                System.out.println("The student with the age " + ages[i] + " cannot vote.");
            }
        }
        sc.close();
    }
}