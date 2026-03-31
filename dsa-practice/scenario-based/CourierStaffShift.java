import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ShiftAlreadyAssignedException extends Exception{
    public ShiftAlreadyAssignedException(String message){
        super(message);
    }
}

class Employees{
    private String employeeId;
    private String name;

    public Employees(String employeeId, String name){
        this.employeeId = employeeId;
        this.name = name;
    }

    public String getEmployeeId(){
         return employeeId;
    }

    public String getName(){
        return name;
    }
}

class ShiftScheduler{
    private List<Employees> staffList = new ArrayList<>();
    private Map<String, List<Employees>> shiftMap = new HashMap<>();

    public void addEmployee(Employees employee){
        staffList.add(employee);
        System.out.println("Employee Added: " + employee.getName());
    }

    public void assignShift(String shiftTime, Employees employee) throws ShiftAlreadyAssignedException{
        shiftMap.putIfAbsent(shiftTime, new ArrayList<>());

        if(shiftMap.get(shiftTime).contains(employee))
            throw new ShiftAlreadyAssignedException("Employee already assigned to this shift.");

        shiftMap.get(shiftTime).add(employee);
        System.out.println(employee.getName() + " assigned to shift " + shiftTime);
    }

    public void displayShift(){
        for(String shift : shiftMap.keySet()){
            System.out.println("Shift: " + shift);
            for(Employees e : shiftMap.get(shift))
                System.out.println(" - " + e.getName());
        }
    }
}

public class CourierStaffShift {
    public static void main(String[] args) {
        try{
            ShiftScheduler scheduler = new ShiftScheduler();

            Employees e1 = new Employees("E101", "Adam");
            Employees e2 = new Employees("E102", "Liam");

            scheduler.addEmployee(e1);
            scheduler.addEmployee(e2);

            scheduler.assignShift("Morning", e1);
            scheduler.assignShift("Morning", e2);
            scheduler.assignShift("Morning", e1);

            scheduler.assignShift("Morning", e1);

            scheduler.displayShift();
        }
        catch(ShiftAlreadyAssignedException e){
            System.out.println(e.getMessage());
        }
    }
}
