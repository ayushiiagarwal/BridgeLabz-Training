import java.util.*;
public class ElectionBoothManager{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int candidate1 = 0, candidate2= 0;
        int candidate3= 0, totalvoters = 0;

        while(true){
            System.out.println("Election Booth Manager");
            System.out.println("Enter age to vote or '0' to exit: ");
            int age = sc.nextInt();
            if(age == 0){
                System.out.println("Elections Closed!");
                break;
            }
            if(age >= 18){
                System.out.println("Status: Eligible!");
                System.out.println("Select your Candidate: ");
                System.out.println("1. Select 1 for Candidate A");
                System.out.println("2. Select 2 for Candidate B");
                System.out.println("3. Select 3 for Candidate C");
                
                int choice = sc.nextInt();

                switch(choice){
                    case 1:
                        candidate1++;
                        totalvoters++;
                        System.out.println("Thank you for voting!");
                        break;
                    case 2:
                        candidate2++;
                        totalvoters++;
                        System.out.println("Thank you for voting!");
                        break;
                    case 3:
                        candidate3++;
                        totalvoters++;
                        System.out.println("Thank you for voting!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }
            else{
                System.out.println("Status: Ineligible!");
            }
        }
        System.out.println("Election Results");
        System.out.println("Candidate A: " + candidate1 + " votes");
        System.out.println("Candidate B: " + candidate2 + " votes");
        System.out.println("Candidate C: " + candidate3 + " votes");
        System.out.println("Total Voters: " + totalvoters);

        sc.close();
    }
}