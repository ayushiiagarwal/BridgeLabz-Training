class Employee{
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails(){
        System.out.println("Name: " + name + ", ID: " + id + "\nSalary: " + salary);
    }
}

class Manager extends Employee{
    int teamSize;

    Manager(String name, int id, double salary, int teamSize){
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Role: Manager" + "\nTeam Size: " + teamSize);
    }
}

class Developer extends Employee{
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage){
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Role: Developer" + "\nProgramming Language: " + programmingLanguage);
    }
}

class Intern extends Employee{
    String university;

    Intern(String name, int id, double salary, String university){
        super(name, id, salary);
        this.university = university;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Role: Intern" + "\nUniversity: " + university);
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Employee manager = new Manager("Olive Smith", 101, 100000.0, 100);
        Employee developer = new Developer("Levi", 110, 80000.0, "Python");
        Employee intern = new Intern("Kaylee", 120, 60000.0, "NIH");

        System.out.println("----Management Details----");
        manager.displayDetails();
        System.out.println();
        developer.displayDetails();
        System.out.println();
        intern.displayDetails();
    }
}
