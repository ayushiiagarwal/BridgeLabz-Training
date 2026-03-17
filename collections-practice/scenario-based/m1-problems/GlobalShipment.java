import java.time.LocalDate;
import java.util.*;

public class GlobalShipment {

    public static void main(String[] args) {

        List<String> modes = Arrays.asList("AIR","SEA","ROAD","RAIL","EXPRESS","FREIGHT");
        List<String> status = Arrays.asList("DELIVERED","CANCELLED","IN_TRANSIT");

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){

            String input = sc.nextLine();
            String[] data = input.split("\\|");

            boolean valid = true;

            // shipment code
            String shipCode = data[0];
            if(!shipCode.matches("SHIP-[1-9][0-9]{5}"))
                valid=false;

            String digits = shipCode.substring(5);

            for(int j=0;j<digits.length()-3;j++){
                if(digits.charAt(j)==digits.charAt(j+1) &&
                   digits.charAt(j)==digits.charAt(j+2) &&
                   digits.charAt(j)==digits.charAt(j+3))
                    valid=false;
            }

            // date
            try{
                LocalDate shipDate = LocalDate.parse(data[1]);

                if(shipDate.getYear()<2000 || shipDate.getYear()>2099)
                    valid=false;

            }catch(Exception e){
                valid=false;
            }

            // mode
            if(!modes.contains(data[2]))
                valid=false;

            // weight
            if(!data[3].matches("(0|[1-9]\\d*)(\\.\\d{1,2})?"))
                valid=false;
            else{
                double w = Double.parseDouble(data[3]);
                if(w>999999.99)
                    valid=false;
            }

            // status
            if(!status.contains(data[4]))
                valid=false;

            if(valid)
                System.out.println("COMPLIANT RECORD");
            else
                System.out.println("NON-COMPLIANT RECORD");
        }

        sc.close();
    }
}