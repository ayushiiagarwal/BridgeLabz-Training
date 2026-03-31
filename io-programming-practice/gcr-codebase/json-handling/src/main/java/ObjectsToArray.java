import java.io.*;
import java.util.*;
import org.json.*;

class Employee{
    int employeeId;
    String employeeName;
    String designation;

    public Employee(int employeeId, String employeeName, String designation){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }
}

public class ObjectsToArray {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee(1, "Adam","HR"),
                                    new Employee(2, "Liam", "Software Engineer"),
                                    new Employee(3, "Olive", "Marketing Intern")
                                );

        JSONArray employeeArray = new JSONArray();

        for(int i = 0; i < employees.size(); i++){
            Employee e = employees.get(i);
            JSONObject json = new JSONObject();
            json.put("EmployeeId", e.employeeId);
            json.put("EmployeeName", e.employeeName);
            json.put("Designation", e.designation);

            employeeArray.put(json);
        }

        try(FileWriter writer = new FileWriter("files/employee.json")){
            writer.write(employeeArray.toString());
            System.out.println("Converted list of objects into a json file");
        }
        catch(IOException e){
            System.out.println("Error!");
        }
    }
}
