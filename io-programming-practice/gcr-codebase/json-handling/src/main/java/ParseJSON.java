import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJSON {
    public static void main(String[] args) throws Exception{
        String content = new String(Files.readAllBytes(Paths.get("files/students.json")));

        JSONArray arr = new JSONArray(content);

        for(int i=0;i<arr.length();i++){
            JSONObject obj = arr.getJSONObject(i);

            if(obj.getInt("age") > 25)
                System.out.println(obj);
        }
    }
}
