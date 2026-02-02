import com.opencsv.*;
import java.io.*;

public class ValidateCSV {
    public static void main(String[] args) throws Exception{
        CSVReader reader = new CSVReader(new FileReader("files/data.csv"));

        String[] line;
        boolean header = true;

        while((line = reader.readNext()) != null){
            if(header){
                header = false;
                continue;
            }

            if(!line[2].matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
                System.out.println("Invalid Email: " + line[2]);

            if(!line[3].matches("^\\\\d{10}$"))
                System.out.println("Invalid Phone: " + line[3]);
        }

        reader.close();
    }
}
