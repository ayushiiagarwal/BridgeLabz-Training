import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Insurance{
    private String claimType;
    private double amount;

    public Insurance(String claimType, double amount){
        this.claimType = claimType;
        this.amount = amount;
    }

    public String getType(){ return claimType; }
    public double getAmount(){ return amount; }

}

public class InsuranceClaim {
    public static void main(String[] args) {
        List<Insurance> insurance = List.of(
            new Insurance("Health", 50000.0),
            new Insurance("Vehicle", 60000.0),
            new Insurance("Life", 1000000.0),
            new Insurance("Vehicle", 40000.0)
        );

        Map<String, Double> avaerage = insurance.stream()
                .collect(
                    Collectors.groupingBy(
                        Insurance::getType, 
                        Collectors.averagingDouble(Insurance::getAmount)
                    )
                );

        avaerage.forEach((type, avg) -> System.out.println(type + ": " + avg));
    }
}
