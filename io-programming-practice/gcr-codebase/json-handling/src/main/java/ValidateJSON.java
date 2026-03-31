import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJSON {
    public static void main(String[] args) {
        ObjectMapper object = new ObjectMapper();

        try{
            String content = new String(Files.readAllBytes(Paths.get("files/read.json")));
            object.readTree(content);
            System.out.println("JSON is Valid");
        }
        catch(Exception e){
            System.out.println("JSON is Invalid");
        }
    }
}
