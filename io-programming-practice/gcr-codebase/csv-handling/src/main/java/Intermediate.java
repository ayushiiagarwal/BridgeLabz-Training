import java.io.*;
import java.util.*;
import com.opencsv.*;

public class Intermediate {

    public static void main(String[] args) throws Exception {

        try (CSVReader reader = new CSVReader(new FileReader("files/students.csv"))) {

            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                if (line.length >= 4 && Integer.parseInt(line[3]) > 80) {
                    System.out.println(line[0] + " | " + line[1] + " | " + line[2] + " | " + line[3]);
                }
            }
        }

        TreeMap<Double, List<String[]>> map =
                new TreeMap<>(Collections.reverseOrder());

        try (
            CSVReader reader2 = new CSVReader(new FileReader("files/employees.csv"));
            CSVWriter writer = new CSVWriter(new FileWriter("files/employeesOutput.csv"))
        ) {

            String[] record;
            boolean header = true;
            String search = "Adam";

            while ((record = reader2.readNext()) != null) {

                if (header) {
                    header = false;
                    writer.writeNext(record);
                    continue;
                }

                if (record.length < 4) continue;

                // search employee
                if (record[1].equalsIgnoreCase(search)) {
                    System.out.println(
                        "\nDepartment: " + record[2] +
                        "\nSalary: " + record[3]
                    );
                }

                // increase salary
                double salary = Double.parseDouble(record[3]);
                if (record[2].equalsIgnoreCase("IT")) {
                    salary *= 1.10;
                    record[3] = String.format("%.2f", salary);
                }

                writer.writeNext(record);

                map.computeIfAbsent(salary, k -> new ArrayList<>()).add(record);
            }
        }

        // Top 5 salaries
        System.out.println("\nTop 5 Highest Paid Employees:");
        int count = 0;

        for (List<String[]> group : map.values()) {
            for (String[] emp : group) {
                if (count++ == 5) return;
                System.out.println(
                    emp[0] + " | " + emp[1] + " | " + emp[2] + " | " + emp[3]
                );
            }
        }
    }
}
