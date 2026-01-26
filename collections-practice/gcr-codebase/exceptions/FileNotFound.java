import java.io.*;

public class FileNotFound{
    public static void main(String[] args) {
        try{
            FileReader fr = new FileReader("example.txt");
            BufferedReader br = new BufferedReader(fr);

            String readLine;
            while((readLine = br.readLine()) != null)
                System.out.println(readLine);

            br.close();
        }
        catch(IOException e){
            System.out.println("Error! \nCannot find  " + e.getMessage());
        }
    }
}