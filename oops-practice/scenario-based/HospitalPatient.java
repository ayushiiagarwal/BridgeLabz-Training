interface IPayable {
    double calculateBill();
}

abstract class Patient{
    private String name;
    private int id;
    private String doctorName;

    public Patient(String name, int id, String doctorName){
        this.name = name;
        this.id = id;
        this.doctorName = doctorName;
    }

    //Encapsulation
    public String getName(){
        return name;
    }

    public int getID(){
        return id;
    }

    public String getDoctorName(){
        return doctorName;
    }

    //Polymorphism
    public abstract void displayInfo();
}

class InPatient extends Patient implements IPayable{
    private int daysStayed;
    private double rate;

    public InPatient(String name, int id, String doctor, int days, double rate){
        super(name, id, doctor);
        this.daysStayed = days;
        this.rate = rate;
    }

    @Override
    public double calculateBill(){
        return daysStayed * rate;
    }

    public void displayInfo(){
        System.out.println("----In-Patient----");
        System.out.println("ID: " + getID());
        System.out.println("Name: " + getName());
        System.out.println("Doctor Name: " + getDoctorName());
        System.out.println("Bill: " + calculateBill());
        System.out.println();
    }
}

class OutPatient extends Patient implements IPayable{
    private double fee;

    public OutPatient(String name, int id, String doctor, double fee){
        super(name, id, doctor);
        this.fee = fee;
    }

    @Override
    public double calculateBill(){
        return fee;
    }

    public void displayInfo(){
        System.out.println("----Out-Patient----");
        System.out.println("ID: " + getID());
        System.out.println("Name: " + getName());
        System.out.println("Doctor: " + getDoctorName());
        System.out.println("Bill: " + calculateBill());
    }
}

public class HospitalPatient {
    public static void main(String[] args) {
        Patient p1 = new InPatient("Olive", 101, "Dr. Chatopadhyay", 5, 1000.0);
        Patient p2 = new OutPatient("Adam", 102, "Dr. Rathore", 2000.0);
        
        p1.displayInfo();
        p2.displayInfo();
    }
}
