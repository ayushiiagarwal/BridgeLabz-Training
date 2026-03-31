import java.util.*;

class InsufficientLeaveBalanceException extends Exception{
    public InsufficientLeaveBalanceException(String message){
        super(message);
    }
}

class Employee{
    String employeeId;
    int leaveBalance;

    public Employee(String employeeId, int leaveBalance){
        this.employeeId = employeeId;
        this.leaveBalance = leaveBalance;
    }
}

class Leave{
    String employeeId, status;
    int days;

    public Leave(String employeeId, int days){
        this.employeeId = employeeId;
        this.days = days;
        this.status = "PENDING";
    }
}

class ManageLeaves{
    private Map<String, Employee> employees = new HashMap<>();

    private List<Leave> leaves = new ArrayList<>();

    public void addEmployee(Employee employee){
        employees.put(employee.employeeId, employee);
    }

    public void requestLeave(String employeeId, int days) throws InsufficientLeaveBalanceException{
        Employee emp = employees.get(employeeId);
        if(emp.leaveBalance < days)
            throw new InsufficientLeaveBalanceException("Insuffiecient Leave Balance for employee " + employeeId);

        leaves.add(new Leave(employeeId, days));
    }

    public void approveLeave(Leave request){
        Employee emp = employees.get(request.employeeId);
        emp.leaveBalance -= request.days;
        request.status = "Approved";
    }

    public void rejectLeave(Leave request){
        request.status = "Rejected";
    }

    public void viewLeaveRequests(){
        for(Leave l : leaves)
            System.out.println(l.employeeId + " Days: " + l.days +
            " Status: " + l.status);
    }

    public List<Leave> getLeaves(){
        return leaves;
    }
}

public class LeaveManagement {
    public static void main(String[] args) {
        ManageLeaves service = new ManageLeaves();

        service.addEmployee(new Employee("EMP101", 10));
        service.addEmployee(new Employee("EMP102", 5));
        service.addEmployee(new Employee("EMP103", 2));

        try{
            service.requestLeave("EMP101", 7);
            service.requestLeave("EMP102", 4);
            service.requestLeave("EMP103", 5);
        }
        catch(InsufficientLeaveBalanceException e){
            System.out.println(e.getMessage());
        }

        Leave leaveRequest = service.getLeaves().get(0);
        service.approveLeave(leaveRequest);

        service.viewLeaveRequests();
    }
}
