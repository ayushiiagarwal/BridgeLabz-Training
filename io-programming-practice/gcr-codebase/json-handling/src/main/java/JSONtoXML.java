import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;
import org.json.XML;

public class JSONtoXML {
    public static void main(String[] args) throws Exception{
        JSONObject object = new JSONObject(new String(Files.readAllBytes(Paths.get("files/read.json"))));
        String xml = XML.toString(object, "Student");

        System.out.println(xml);
    }
}
