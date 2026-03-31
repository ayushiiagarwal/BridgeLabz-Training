import java.io.FileReader;
import com.opencsv.CSVReader;

public class ReadLarge {
    public static void main(String[] args) throws Exception{
        CSVReader reader = new CSVReader(new FileReader("files/large.csv"));
        int count = 0;
        String[] row;

        while ((row = reader.readNext()) != null) {
            count++;
            if (count % 100 == 0)
                System.out.println("Processed: " + count);
            System.out.println(row[0]);
        }
        reader.close();
    }
}
