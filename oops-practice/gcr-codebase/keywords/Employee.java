public class Employee {
    private static String companyName = "Tech Solutions Inc.";
    private static int totalEmployees = 0;
    private String name, designation;
    private final int id;

    public Employee(int id, String name, String designation){
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees(){
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails(){
        if(this instanceof Employee){
            System.out.println("Company name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
        else
            System.out.println("The Employee doesn't works here");
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Thamarai", "Software Engineer");
        Employee e2 = new Employee(102, "Rohan", "Project Manager");

        displayTotalEmployees();
        e1.displayDetails();
        e2.displayDetails();
    }
}
