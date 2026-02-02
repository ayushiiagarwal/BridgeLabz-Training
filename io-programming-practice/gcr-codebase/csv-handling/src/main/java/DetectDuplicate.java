import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import com.opencsv.CSVReader;

public class DetectDuplicate {
    public static void main(String[] args) throws Exception{
        Set<String> seen = new HashSet<>();
        CSVReader reader = new CSVReader(new FileReader("files/students.csv"));
        String[] row;

        reader.readNext();
        while((row = reader.readNext()) != null){
            if((!seen.add(row[0])))
                System.out.println("Duplicate ID: " + row[0] + ", " + row[1] + ", " + row[2] + ", " + row[3]);
        }

        reader.close();
    }
}
