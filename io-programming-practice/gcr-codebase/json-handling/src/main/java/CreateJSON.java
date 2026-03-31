import org.json.JSONObject;
import java.util.*;


public class CreateJSON {
    public static void main(String[] args) throws Exception{

        JSONObject student = new JSONObject();

        student.put("name", "Adam");
        student.put("age", 20);
        student.put("subjects", Arrays.asList("Math", "Science", "English"));

        System.out.println("Create a JSON Object");
        System.out.println(student.toString());     
    }
}
