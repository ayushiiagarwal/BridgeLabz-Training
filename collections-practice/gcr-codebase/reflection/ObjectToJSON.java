import java.lang.reflect.Field;

public class ObjectToJSON {
    public static String toJson(Object obj) throws Exception {
        StringBuilder sb = new StringBuilder("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            sb.append("\"")
              .append(f.getName())
              .append("\":\"")
              .append(f.get(obj))
              .append("\",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
}