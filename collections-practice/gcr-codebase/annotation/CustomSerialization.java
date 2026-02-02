import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {

    @JsonField(name = "name")
    private String username;

    @JsonField(name = "age")
    private int userAge;

    User(String name, int age) {
        username = name;
        userAge = age;
    }
}

public class CustomSerialization {

    public static String toJson(Object obj) throws Exception {
        StringBuilder sb = new StringBuilder("{");

        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField jf = field.getAnnotation(JsonField.class);
                sb.append("\"").append(jf.name()).append("\":\"")
                  .append(field.get(obj)).append("\",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        User user = new User("Ayushi", 21);
        System.out.println(toJson(user));
    }
}