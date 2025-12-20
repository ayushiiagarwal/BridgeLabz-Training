import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];
        double[] newSalaries = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < 10; ) {
            double salary = sc.nextDouble();
            double year = sc.nextDouble();

            if (salary <= 0 || year < 0) {
                System.out.println("Invalid input, Try again!");
                continue;
            }

            salaries[i] = salary;
            years[i] = year;
            i++;
        }

        for (int i = 0; i < 10; i++) {
            if (years[i] > 5) {
                bonus[i] = salaries[i] * 0.05;
            } else {
                bonus[i] = salaries[i] * 0.02;
            }
            newSalaries[i] = salaries[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("Total Bonus = " + totalBonus);
        System.out.println("Total Old Salary = " + totalOldSalary);
        System.out.println("Total New Salary = " + totalNewSalary);

        sc.close();
    }
}
