import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class CSVtoJSON{
    public static void main(String[] args) throws Exception{
        List<String> lines = Files.readAllLines(Paths.get("files/students.csv"));
        String[] headers = lines.get(0).split(",");

        JSONArray arr = new JSONArray();

        for(int i=1;i<lines.size();i++){
            String[] values = lines.get(i).split(",");
            JSONObject obj = new JSONObject();

            for(int j=0;j<headers.length;j++)
                obj.put(headers[j], values[j]);

            arr.put(obj);
        }

        System.out.println(arr.toString());
    }
}