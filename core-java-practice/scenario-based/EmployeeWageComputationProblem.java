import java.util.*;

interface IEmpWageBuilder {
    void addCompany(String companyName, int wagePerHour, int workingDays, int maxHours);
    void computeWage();
    int getTotalWage(String companyName);
}

class CompanyEmpWage {
    String companyName;
    int wagePerHour;
    int workingDays;
    int maxHours;
    int totalWage;
    ArrayList<Integer> dailyWages;    

    public CompanyEmpWage(String companyName, int wagePerHour, int workingDays, int maxHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.maxHours = maxHours;
        this.totalWage = 0;
        this.dailyWages = new ArrayList<>();
    }

    public void setTotalWage(int totalWage){ this.totalWage = totalWage; }

    public int getTotalWage(){ return this.totalWage; }
}

class EmpWageBuilder implements IEmpWageBuilder {

    ArrayList<CompanyEmpWage> companyList;

    public EmpWageBuilder(){
        companyList = new ArrayList<>();
    }

    public void addCompany(String companyName, int wagePerHour, int workingDays, int maxHours) {
        CompanyEmpWage company = new CompanyEmpWage(companyName, wagePerHour, workingDays, maxHours);
        companyList.add(company);
    }

    public void computeWage(){
        for (CompanyEmpWage company : companyList){
            int totalHours = 0;
            int totalDays = 0;

            while(totalHours < company.maxHours && totalDays < company.workingDays) {
                totalDays++;
                int empHours = 0;
                int attendance = (int) (Math.random() * 3);

                switch (attendance) {
                    case 1:
                        empHours = 8;  // Full time
                        break;
                    case 2:
                        empHours = 4;  // Part time
                        break;
                    default:
                        empHours = 0;  // Absent
                }

                totalHours += empHours;

                int dailyWage = empHours * company.wagePerHour;
                company.dailyWages.add(dailyWage);   

                company.totalWage += dailyWage;
            }

            company.setTotalWage(company.totalWage);
            System.out.println("Total Wage for " + company.companyName + " = " + company.totalWage);
        }
    }

    public int getTotalWage(String companyName) {
        for(CompanyEmpWage company : companyList){
            if(company.companyName.equals(companyName))
                return company.getTotalWage();
        }
        return 0;
    }
}

public class EmployeeWageComputationProblem {

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program!");

        EmpWageBuilder builder = new EmpWageBuilder();

        builder.addCompany("Microsoft", 20, 20, 100);
        builder.addCompany("Google", 25, 22, 120);

        builder.computeWage();

        System.out.println("Queried Wage for Microsoft = " + builder.getTotalWage("Microsoft"));
    }
}
