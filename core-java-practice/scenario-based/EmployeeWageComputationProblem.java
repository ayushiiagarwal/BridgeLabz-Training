public class EmployeeWageComputationProblem{
    public static final int partTime = 1;
    public static final int fullTime = 2;
    public static final int wagePerHour = 20;    
    public static final int workingDays = 20; 
    public static final int maxHours = 100;   

    public static int useCase1() {
        return (int) Math.floor(Math.random() * 10) % 3;
    }

    public static int useCase4(int empCheck) {
        int empHrs = 0;
        switch (empCheck) {
            case partTime:
                empHrs = 8; 
                break;
            case fullTime:
                empHrs = 8; 
                break;
            default:
                empHrs = 0;
        }
        return empHrs;
    }

    public static int useCase2(int empHrs) {
        return empHrs * wagePerHour;
    }

    public static void computeMonthlyWage() {
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;

        while (totalEmpHrs < maxHours && totalWorkingDays < workingDays) {
            totalWorkingDays++;
            
            int empCheck = useCase1(); 
            int empHrs = useCase4(empCheck); 
            
            if (totalEmpHrs + empHrs > maxHours) {
                empHrs = maxHours - totalEmpHrs;
            }
            
            totalEmpHrs += empHrs;
            int dailyWage = useCase2(empHrs);
            System.out.println("Day " + totalWorkingDays + ", Hours: " + empHrs + ", Wage: " + dailyWage);
        }

        int totalEmpWage = totalEmpHrs * wagePerHour;
    
        System.out.println("Total Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalEmpHrs);
        System.out.println("Total Monthly Employee Wage: " + totalEmpWage);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        computeMonthlyWage();
    }
}
