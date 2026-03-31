import java.io.FileReader;
import java.io.FileWriter;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Basic {
    public static void main(String[] args) throws Exception{
        // Read a CSV File
        CSVReader reader = new CSVReader(new FileReader("files/students.csv"));
            String[] line;
            int count = -1;
            while ((line = reader.readNext()) != null){
                System.out.println(line[0] + " | " + line[1]);
                count++;
            }

            System.out.println("Number of records excluding the header row: " + count);

        reader.close();

        // Write a CSV file
        CSVWriter writer = new CSVWriter(new FileWriter("files/employeesOutput.csv"));
        
        String[] header = {"ID", "Name", "Department", "Salary"};

        String[] emp1 = {"104", "Alice Williams", "Finance", "62000"};
        
        String[] emp2 = {"105", "Bob Johnson", "Sales", "58000"};

        writer.writeNext(header);
        writer.writeNext(emp1);
        writer.writeNext(emp2);

        System.out.println("\nCSV file written successfully using OpenCSV");

        writer.close();
    }
}
