public class RobotHazardAuditor{
    public double calculateHazardRisk(double armPrecision, int workDensity, String machineryState) throws RobotSafetyException{
        
        if(!(armPrecision >= 0.0 && armPrecision <= 1.0))
            throw new RobotSafetyException("Error: Arm Precision must be 0.0-1.0!");
        
        else if(!(workDensity >= 1 && workDensity <= 20))
            throw new RobotSafetyException("Error: Work Density must be 1-20!");

        else if(!(machineryState.equals("Worn") || 
                 machineryState.equals("Faulty") ||
                 machineryState.equals("Critical")))
            throw new RobotSafetyException("Error: Unsupported machinery State!");

        else{
            double hazardRisk = ((1.0 - armPrecision) * 15.0) + (workDensity * calculateMachineRiskFactor(machineryState));
            return hazardRisk;
        }
    
    }

    public double calculateMachineRiskFactor(String machineryState){
        if(machineryState.equalsIgnoreCase("Worn"))
            return 1.3;

        else if(machineryState.equalsIgnoreCase("Faulty"))
            return 2.0;
        
        else if(machineryState.equalsIgnoreCase("Critical"))
            return 3.0;

        return 0;
    }
}