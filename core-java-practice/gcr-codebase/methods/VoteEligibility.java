import java.util.*;
public class VoteEligibility {

    public static boolean canVote(int age){
        if(age < 0) return false;

        else if(age >= 18) return true;

        else return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter age: ");
        int age = sc.nextInt();

        boolean result = canVote(age);
        System.out.println(result);

        System.out.println("Enter ages for 10 students: ");
        int[] students = new int[10];
        for(int i=0;i<students.length;i++){
            students[i] = sc.nextInt();
        }
        for(int i=0;i<students.length;i++){
            boolean res = canVote(students[i]);
            System.out.println("Student " + (i+1) + " with age " + students[i] + " can vote: " + res);
        }
        
        sc.close();
    }
}
