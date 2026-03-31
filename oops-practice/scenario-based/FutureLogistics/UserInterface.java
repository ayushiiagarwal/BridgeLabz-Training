import java.util.*;

public class UserInterface{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Goods Transport Details");
        String details = sc.nextLine();
        System.out.println();

        Utility utility = new Utility();

        GoodsTransport transport = utility.parseDetails(details);
        if(!utility.validTransport(transport.getId())){
            System.out.println("Transport ID: " + transport.getId() + " is Invalid! \nPlease Provide a valid record.");
            return;
        }

        String objectType = utility.findObjectType(transport);

        double totalCharge = 0.0;

        if(objectType.equalsIgnoreCase("BrickTransport")){
            BrickTransport transportB = (BrickTransport) transport;
            if(!utility.validTransport(transportB.getId()))
                return;

            totalCharge = transportB.calculateTotalCharge();

            System.out.println("Transport ID: " + transportB.getId() + 
            "\nDate of Transport: " + transportB.getDate() + 
            "\nRating of the Transport: " + transportB.getRating() +
            "\nQuantity of Bricks: " + transportB.getQuantity() +
            "\nVehicle for Transport: " + transportB.vehicleSelection() +
            "\nTotal Charge: " + totalCharge);
        }

        else if(objectType.equalsIgnoreCase("TimberTransport")){
            TimberTransport transportT = (TimberTransport) transport;

            if(!utility.validTransport(transportT.getId()))
                return;

            totalCharge = transportT.calculateTotalCharge();

            System.out.println("Transport ID: " + transportT.getId() + 
            "\nDate of Transport: " + transportT.getDate() + 
            "\nRating of the Transport: " + transportT.getRating() +
            "\nType of the timber: " + transportT.getType() +
            "\nTimber price per kilo: " + transportT.getTimberPrice() +
            "\nVehicle for Transport: " + transportT.vehicleSelection() +
            "\nTotal Charge: " + totalCharge);
        }
    }
}