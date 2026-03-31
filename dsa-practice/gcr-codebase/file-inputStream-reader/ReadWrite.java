// Read USer Input and Write to File Using InputStreamReader
import java.io.*;
public class ReadWrite {
    public static void main(String[] args) {
        try{
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            FileWriter fw = new FileWriter("example.txt", true);

            String input;

            System.out.println("Enter text (type 'exit' to stop): ");

            while(true){
                input = br.readLine();

                if(input.equalsIgnoreCase("exit"))
                    break;

                fw.write(input + System.lineSeparator());
            }
            fw.close();
            br.close();
            isr.close();

            System.out.println("Input Successfully written to file");
        }catch(IOException e){
            System.out.println("Error reading/writing the file");
        }
    }
}
