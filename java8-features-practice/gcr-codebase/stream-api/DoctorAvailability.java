import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Doctor{
    private String name, speciality;
    private boolean isAvailable;

    public Doctor(String name, String speciality, boolean isAvailable){
        this.name = name;
        this.speciality = speciality;
        this.isAvailable = isAvailable;
    }

    public String getName(){ return name; }
    public String getSpeciality(){ return speciality; }
    public boolean availableOnWeekend(){ return isAvailable; }

    public String toString(){
        return name + " | " + speciality + (isAvailable ? " | Available on Weekend!" : "Not Available on Weekend");
    }
}

public class DoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = List.of(
            new Doctor("Dr. A", "Orthologist", true),
            new Doctor("Dr. B", "Neurologist", false),
            new Doctor("Dr. C", "Cardiologist", true),
            new Doctor("Dr. D", "Dermatologist", true)
        );

        List<Doctor> list = doctors.stream()
                        .filter(Doctor::availableOnWeekend)
                        .sorted(Comparator.comparing(Doctor::getSpeciality))
                        .collect(Collectors.toList());

        list.forEach(System.out::println);
    }
}
