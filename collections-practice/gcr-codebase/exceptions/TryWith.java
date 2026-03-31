import java.io.*;

public class TryWith {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("info.txt")))
        {
            System.out.println(br.readLine());

            br.close();
        }
        catch(IOException e){
            System.out.println("Error Reading file " + e.getMessage());
        }
    }
}
