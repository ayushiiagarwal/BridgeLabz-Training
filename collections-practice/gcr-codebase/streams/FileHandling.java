import java.io.*;
public class FileHandling{
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("input.txt");
             FileWriter fw = new FileWriter("output.txt")){
                int charData;
                while((charData = fr.read()) != -1)
                    fw.write(charData);

                System.out.println("File Copied Successfully");
        } catch(IOException e){
            e.getMessage();
            System.out.println("Error: File not found");
        }
    }
}