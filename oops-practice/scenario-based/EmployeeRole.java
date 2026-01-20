abstract class Employee{
    private final String name;
    private final double salary;

    Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    String getName(){
        return name;
    }

    double getSalary(){
        return salary;
    }

    abstract double getBonus();
}

class Manager extends Employee{
    private final double bonus;

    Manager(String name, double salary){
        super(name, salary);
        this.bonus = salary * 0.10;
    }

    double getBonus(){
        return bonus;
    }
}

class Developer extends Employee{
    private final double bonus;

    Developer(String name, double salary){
        super(name, salary);
        if(salary > 50000){
            this.bonus = salary * 0.05;
        }
        else this.bonus = 0.0;
    }

    double getBonus(){
        return bonus;
    }
}

public class EmployeeRole {
    public static void main(String[] args) {
        Employee manager = new Manager("Adam", 80000);
        System.out.println("Name: " + manager.getName());
        System.out.printf("%.2f%n", manager.getBonus());
        System.out.println();

        Employee dev1 = new Developer("Liam", 60000);
        System.out.println("Name: " + dev1.getName());
        System.out.printf("%.2f%n", dev1.getBonus());
        System.out.println();

        Employee dev2 = new Developer("Olive", 40000);
        System.out.println("Name: " + dev2.getName());
        System.out.printf("%.2f%n", dev2.getBonus());
    }
}
