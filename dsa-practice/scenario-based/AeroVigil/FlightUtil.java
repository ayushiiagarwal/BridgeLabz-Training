public class FlightUtil{
    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException{
        if(!flightNumber.matches("^FL-[1-9][0-9]{3}$"))
            throw new InvalidFlightException("The flight Number " + flightNumber + " is invalid!");

        return true;
    }

    public boolean validateFlightName(String flightName) throws InvalidFlightException{
        if(!(flightName.equalsIgnoreCase("SpiceJet") ||
            flightName.equalsIgnoreCase("Vistara") ||
            flightName.equalsIgnoreCase("IndiGo") ||
            flightName.equalsIgnoreCase("Air Arabia")))
            throw new InvalidFlightException("The flight name " + flightName + " is invalid!");

        return true;
    }

    public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException{
        if((flightName.equalsIgnoreCase("SpiceJet") && passengerCount <= 396 && passengerCount > 0) ||
           (flightName.equalsIgnoreCase("Vistara") && passengerCount <= 615 && passengerCount > 0) ||
           (flightName.equalsIgnoreCase("IndiGO") && passengerCount <= 230 && passengerCount > 0) ||
           (flightName.equalsIgnoreCase("Air Arabia") && passengerCount <= 130 && passengerCount > 0))
           return true;

        throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
    }

    public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException{
        if((flightName.equalsIgnoreCase("SpiceJet") && currentFuelLevel <= 200000 && currentFuelLevel >= 0))
            return 200000 - currentFuelLevel;

        else if((flightName.equalsIgnoreCase("Vistara") && currentFuelLevel <= 300000 && currentFuelLevel >= 0))
            return 300000 - currentFuelLevel;

        else if((flightName.equalsIgnoreCase("IndiGo") && currentFuelLevel <= 250000 && currentFuelLevel >= 0))
            return 250000 - currentFuelLevel;

        else if((flightName.equalsIgnoreCase("Air Arabia") && currentFuelLevel <= 150000 && currentFuelLevel >= 0))
            return 150000 - currentFuelLevel;

        throw new InvalidFlightException("Invalid fuel level for " + flightName);
    }
}