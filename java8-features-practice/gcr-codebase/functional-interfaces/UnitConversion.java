interface Conversions{
    static double kmToMiles(double distance){
        return distance * 0.621371;
    }

    static double kgToLbs(double weight){
        return weight * 2.20462;
    }
}

public class UnitConversion {
    public static void main(String[] args) {
        System.out.println(Conversions.kmToMiles(17.5));
        System.out.println(Conversions.kgToLbs(48));
    }
}
