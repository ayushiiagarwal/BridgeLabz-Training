import java.nio.file.*;
import org.json.JSONObject;

public class ReadJSON {
    public static void main(String[] args) throws Exception{
        String content = new String(Files.readAllBytes(Paths.get("files/read.json")));

        JSONObject file = new JSONObject(content);

        System.out.println("Read JSON file and extract specific fields");
        System.out.println("Name: " + file.getString("name"));
        System.out.println("Email: " + file.getString("email"));
    }    
}
