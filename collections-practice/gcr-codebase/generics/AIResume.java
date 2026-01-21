import java.util.*;

abstract class JobRole{
    abstract void roleName();
}

class SoftwareEnginner extends JobRole{
    void roleName(){
        System.out.println("Software Engineer");
    }
}

class DataScientist extends JobRole{
    void roleName(){
        System.out.println("Data Scientist");
    }
}

class ProductManager extends JobRole{
    void roleName(){
        System.out.println("Product Manager");
    }
}

class Resume<T extends JobRole>{
    private T role;

    public Resume(T role){
        this.role = role;
    }
    public void processResume(){
        role.roleName();
    }
}

class ResumeUtility{
    public static <T extends JobRole> Resume<T> screenResume(T role) {
        return new Resume<>(role);
    }

    public static void screeningPipeline(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            role.roleName();
        }
    }
}

public class AIResume {
    public static void main(String[] args) {
        // Resume<SoftwareEnginner> SE = ResumeUtility.screenResume(new SoftwareEnginner());
        // Resume<DataScientist> DS = ResumeUtility.screenResume(new DataScientist());
        // Resume<ProductManager> PM = ResumeUtility.screenResume(new ProductManager());

        // System.out.println("Roles: ");
        // SE.processResume();
        // DS.processResume();
        // PM.processResume();

        // System.out.println("\nScreening Pipeline: ");
        // List<JobRole> roles = new ArrayList<>();
        // roles.add(new SoftwareEnginner());
        // roles.add(new DataScientist());
        // roles.add(new ProductManager());

        // ResumeUtility.screeningPipeline(roles);

        Scanner sc = new Scanner(System.in);
        System.out.println("Select your Role: ");
        System.out.println("1. Software Engineer\n" +
                            "2. Data Scientist\n" +
                            "3. Product Manager");
        
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                ResumeUtility.screenResume(new SoftwareEnginner()).processResume();
                break;
            
            case 2:
                ResumeUtility.screenResume(new DataScientist()).processResume();
                break;
        
            case 3:
                ResumeUtility.screenResume(new ProductManager()).processResume();
                break;

            default:
                System.out.println("Invalid Choice! Select from the above roles only.");
                break;
        }

        sc.close();
    }
}
