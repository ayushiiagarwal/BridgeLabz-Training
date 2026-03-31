import java.util.*;

class Employee{
    String name, department;

    Employee(String name, String department){
        this.name = name;
        this.department = department;
    }

    public String toString(){
        return name;
    }
}

public class GroupObjects {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));

        System.out.println("Employees: " + employees);

        Map<String, List<Employee>> map = new HashMap<>();

        for(Employee e : employees){
            if(!map.containsKey(e.department))
                map.put(e.department, new ArrayList<>());

            map.get(e.department).add(e);
        }
        for (String dept : map.keySet()) {
            System.out.println(dept + " -> " + map.get(dept));
        }
    }
}
