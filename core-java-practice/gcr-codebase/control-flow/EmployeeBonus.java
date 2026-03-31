// program to find the bonus of employees based on their years of service

import java.util.Scanner;
public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the salary: ");
        int salary = sc.nextInt();

        System.out.println("Enter the Years: ");
        int years = sc.nextInt();

        if (years > 5) {
            double bonus = 0.05 * salary;
            System.out.println("Bonus is: " + bonus);
        } else {
            System.out.println("No bonus.");
        }

        sc.close();
    }
}
