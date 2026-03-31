class EmployeeDetails{
    String name;
	int id;
	double salary;
	
	EmployeeDetails(String name, int id,double salary){
		this.name=name;
		this.id=id;
		this.salary=salary;
	}
	
	public  void displayEmployee() {
		System.out.println("Employee Name: "+name);
		System.out.println("Employee id: "+id);
		System.out.println("Employee Salary: "+salary);
	}
	
	public static void main(String[] args) {

	    EmployeeDetails emp=new EmployeeDetails("Rohan",1,500000);
	    emp.displayEmployee();
	}
}