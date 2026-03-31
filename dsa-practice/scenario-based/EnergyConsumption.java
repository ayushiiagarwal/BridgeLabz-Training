import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InvalidEnergyReadingException extends Exception{
    public InvalidEnergyReadingException(String message){
        super(message);
    }
}

class Monitor{
    private Map<Date, List<Double>> energyData;

    public Monitor(){
        energyData = new HashMap<>();
    }

    public void addReading(Date date, double reading) throws InvalidEnergyReadingException{
        if(reading < 0)
            throw new InvalidEnergyReadingException(reading + ", Energy reading cannot be negative.");
        
        energyData.putIfAbsent(date, new ArrayList<>());
        energyData.get(date).add(reading);
    }

    public double calculateDailyAverage(Date date){
        List<Double> readings = energyData.get(date);

        if(readings == null || readings.isEmpty())
            return 0.0;

        double sum = 0;
        for(double value : readings)
            sum += value;

        return sum / readings.size();
    }

    public double calculateMonthlyAverage(int month, int year){
        double totalSum = 0;
        int totalCount = 0;

        Calendar cal = Calendar.getInstance();

        for(Map.Entry<Date, List<Double>> entry : energyData.entrySet()){
            cal.setTime(entry.getKey());

            int entryMonth = cal.get(Calendar.MONTH);
            int entryYear = cal.get(Calendar.YEAR);

            if(entryMonth == month && entryYear == year){
                for(double value : entry.getValue()){
                    totalSum += value;
                    totalCount++;
                }
            }
        }

        if(totalCount == 0)
            return 0.0;

        return totalSum / totalCount;
    }

    public void genrateReport(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");

        System.out.println("\nEnergy Consumption Report");

        for(Map.Entry<Date, List<Double>> entry : energyData.entrySet()){
            double avg = calculateDailyAverage(entry.getKey());

            System.out.println("Date: " + sdf.format(entry.getKey()) + "\nReadings: " + entry.getValue() + "\nDaily Average: " + avg);
            System.out.println();
        }
    }
}

public class EnergyConsumption {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");

        try{
            Date d1 = sdf.parse("01-02-2026");
            Date d2 = sdf.parse("02-02-2026");

            monitor.addReading(d1, 12.5);
            monitor.addReading(d2, 15.0);
            monitor.addReading(d1, 10.0);
            monitor.addReading(d2, 8.5);

            monitor.addReading(d2, -5.0);
        }
        catch(InvalidEnergyReadingException e){
            System.out.println("Error: " + e.getMessage());
        }
        catch(Exception e){
            e.printStackTrace();
        }

        monitor.genrateReport();

        try{
            Date d1 = sdf.parse("01-02-2026");
            System.out.println("Daily Avaerage: " + monitor.calculateDailyAverage(d1));

            System.out.println("Monthly Average: " + monitor.calculateMonthlyAverage(1, 2026));
        }
        catch(Exception e ){
            e.printStackTrace();
        }
    }
}
