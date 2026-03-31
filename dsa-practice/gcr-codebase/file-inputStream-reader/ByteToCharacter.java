// Convert Byte Stream to Character Stream Using InputStreamReader

import java.io.*;
public class ByteToCharacter {
    public static void main(String[] args) {
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream("example.txt"), "UTF-8")){
            int i;
            while((i = isr.read()) != -1)
                System.out.print((char) i);
        }catch(IOException e){
            System.out.println("Error Reading the file");
        }        
    }
}
