// Read a file Line by line using FileReader
import java.io.*;
public class ReadFile{
    public static void main(String[] args) {
        try(FileReader fr = new FileReader("example.txt")){
            int i;
            while((i = fr.read()) != -1)
                System.out.print((char) i);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}