import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = sc.nextDouble();

        System.out.println("Enter Work Density (1 - 20):");
        int workDensity = sc.nextInt();

        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        String machineryState = sc.next();

        RobotHazardAuditor auditor = new RobotHazardAuditor();

        try{
            System.out.println("Robot Hazard Risk Score: " + auditor.calculateHazardRisk(armPrecision, workDensity, machineryState));
        }
        catch(RobotSafetyException e){
            System.out.println(e.getMessage());
        }

        sc.close();

    }
}
