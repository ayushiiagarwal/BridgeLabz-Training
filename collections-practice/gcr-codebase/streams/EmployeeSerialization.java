import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(101, "Adam", "IT", 72000));
        list.add(new Employee(102, "Liam", "HR", 54000));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employees.ser"))) {
            out.writeObject(list);
        } catch (IOException e) {
            System.out.println("Couldn't write: " + e.getMessage());
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employees.ser"))) {
            List<Employee> readList = (List<Employee>) in.readObject();
            for (Employee emp : readList) {
                System.out.println(emp.id + ", " + emp.name + ", \n" + emp.department + ", " + emp.salary);
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Couldn't read: " + e.getMessage());
        }
    }
}