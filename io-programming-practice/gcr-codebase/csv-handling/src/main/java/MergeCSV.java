
import com.opencsv.*;
import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) throws Exception {
        Map<String, String[]> map = new HashMap<>();

        CSVReader reader1 = new CSVReader(new FileReader("files/students1.csv"));
        CSVReader reader2 = new CSVReader(new FileReader("files/students2.csv"));
        CSVWriter writer = new CSVWriter(new FileWriter("files/merged.csv"));

        reader1.readNext();
        reader2.readNext();
        String[] row;

        while ((row = reader1.readNext()) != null)
            map.put(row[0], row);

        while ((row = reader2.readNext()) != null) {
            String[] s = map.get(row[0]);
            if (s != null)
                writer.writeNext(new String[]{s[0], s[1], s[2], row[1], row[2]});
        }

        reader1.close(); reader2.close(); writer.close();
    }
}