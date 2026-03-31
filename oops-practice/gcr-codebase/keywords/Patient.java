public class Patient {
    private static String hospitalName = "City Hospital";
    private String name;
    private int age;
    private String ailment;
    private final String patientID;
    private static int totalPatients = 0;

    public Patient(String patientID, String name, int age, String ailment){
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public void displayPatientDetails(){
        if(this instanceof Patient){
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }

    public static void getTotalPatients(){
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("P001", "Lathika", 30, "Flu");
        Patient p2 = new Patient("P002", "Lidiya", 45, "Fracture");

        getTotalPatients();
        System.out.println();
        p1.displayPatientDetails();
        System.out.println();
        p2.displayPatientDetails();
    }
}
