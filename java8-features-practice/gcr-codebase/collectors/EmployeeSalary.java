import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee{
    private String dept;
    private double salary;

    public Employee(String dept, double salary){
        this.dept = dept;
        this.salary = salary;
    }

    public String getDepartment(){ return dept; }
    public double getSalary(){ return salary; } 

}

public class EmployeeSalary {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("IT", 90000.0),
            new Employee("HR", 52000.0),
            new Employee("Finance", 50000.0)
        );

        Map<String, Double> avgSalaryByDept = employees.stream()
                    .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                    ));
        
        avgSalaryByDept.forEach((d, s) -> System.out.println(d + " - " + s));
    }
}
