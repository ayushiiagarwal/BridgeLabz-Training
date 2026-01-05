abstract class Patient{
    private String name;
    private int patientID, age;

    public Patient(int patientID, String name, int age){
        this.patientID = patientID;
        this.name = name;
        this.age = age;
    }

    public void getPatientDetails(){
        System.out.println("Patient ID: " + patientID);
        System.out.println("Patient Name: " + name);
        System.out.println("Patient's Age: " + age);
    }

    public abstract double calculateBill();
}

interface MedicalRecord{
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord{
    private int daysAdmitted;
    private String[] records = new String[5];
    private int recordCount = 0;

    public InPatient(int patientID, String name, int age, int daysAdmitted){
        super(patientID, name, age);
        this.daysAdmitted = daysAdmitted;
    }

    @Override
    public double calculateBill(){
        return daysAdmitted * 2000.0;
    }

    public void addRecord(String record){
        if(recordCount < records.length)
            records[recordCount++] = record;
    }

    public void viewRecords(){
        System.out.println("Medical Records: ");
        for(String r : records){
            if(r != null)
                System.out.println("- " + r);
        }
    }
}

class OutPatient extends Patient implements MedicalRecord{
    private int consultations;
    private String[] records = new String[5];
    private int recordCount = 0;

    public OutPatient(int patientID, String name, int age, int consultations){
        super(patientID, name, age);
        this.consultations =  consultations;
    }

    @Override
    public double calculateBill(){
        return consultations * 1000.0;
    }

    public void addRecord(String record){
        if(recordCount < record.length())
            records[recordCount++] = record;
    }

    public void viewRecords(){
        System.out.println("Medical Records: ");
        for(String r : records){
            if(r != null)
                System.out.println("- " + r);
        }
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Patient[] patients = {
            new InPatient(1001, "Priya", 25, 7),
            new OutPatient(2001, "Abhishek", 29, 3)
        };

        for(Patient p : patients){
            p.getPatientDetails();
            System.out.println("Total Bill: " + p.calculateBill());

            if(p instanceof MedicalRecord){
                MedicalRecord mr = (MedicalRecord) p;
                mr.addRecord("Diagnosis: Flu");
                mr.addRecord("Medications: Calpol");
                mr.viewRecords();
            }

            System.out.println();
        }
    }
}
