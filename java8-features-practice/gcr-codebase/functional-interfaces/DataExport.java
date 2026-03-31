interface Report{
    void export(String data);

    default void exportJSON(String data){
        System.out.println("Exporting data into a JSON file!");
    }
}

class CSV implements Report{
    public void export(String data){
        System.out.println("Exporting data into a CSV file.");
    }
}

class PDF implements Report{
    public void export(String data){
        System.out.println("Exporting data into a PDF file.");
    }
}

public class DataExport {
    public static void main(String[] args) {
        Report data1 = new CSV();
        Report data2 = new PDF();

        String report = "Data Export Feature";

        data1.export(report);
        data1.exportJSON(report);
        System.out.println();

        data2.export(report);
        data2.exportJSON(report);
    }
}
