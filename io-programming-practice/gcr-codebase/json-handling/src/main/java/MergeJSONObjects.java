import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class MergeJSONObjects {
    public static void main(String[] args) throws Exception{
        JSONObject content1 = new JSONObject(new String(Files.readAllBytes(Paths.get("files/file1.json"))));
        JSONObject content2 = new JSONObject(new String(Files.readAllBytes(Paths.get("files/file2.json"))));

        JSONArray arr = new JSONArray();

        for(String key : content2.keySet())
            content1.put(key, content2.get(key));

        arr.put(content1);

        try(FileWriter writer = new FileWriter("files/merged.json")){
            writer.write(arr.toString(2));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }    
}
