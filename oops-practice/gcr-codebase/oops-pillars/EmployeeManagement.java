interface Department{
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

abstract class Employee{
    int employeeID;
    String name;
    double baseSalary;

    Employee(int employeeID, String name, double baseSalary){
        this.employeeID = employeeID;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId(){
        return employeeID;
    }

    public String getName(){
        return name;
    }

    public double getBaseSalary(){
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary){
        if(baseSalary > 0)
            this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails(){
        System.out.println("Employee ID: " + employeeID + "\nName: " + name + "\nSalary: " + baseSalary);
    }
}

class FullTimeEmployee extends Employee implements Department{
    private String deptName;
    
    public FullTimeEmployee(int employeeID, String name, double baseSalary){
        super(employeeID, name, baseSalary);
    }

    @Override
    public double calculateSalary(){
        return getBaseSalary();
    }

    @Override
    public void assignDepartment(String deptName){
        this.deptName = deptName;
    }

    @Override
    public String getDepartmentDetails(){
        return "Department: " + deptName;
    }
}

class PartTimeEmployees extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployees(int employeeID, String name, double baseSalary, int hoursWorked, double hourlyRate){
        super(employeeID, name, baseSalary);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary(){
        baseSalary = hourlyRate * hoursWorked;
        return baseSalary;
    }
}

public class EmployeeManagement{
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee(1001, "Liam Hardings", 50000.0);
        Employee emp2 = new PartTimeEmployees(2001, "Marie", 1000.0, 100, 100);

        emp1.calculateSalary();
        emp1.displayDetails();

        System.out.println();

        emp2.calculateSalary();
        emp2.displayDetails();
    }
}