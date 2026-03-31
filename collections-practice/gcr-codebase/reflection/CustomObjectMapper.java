import java.lang.reflect.Field;
import java.util.Map;

public class CustomObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> map)
            throws Exception {

        T obj = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : map.entrySet()){

            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(obj, entry.getValue());

        }
        
        return obj;
    }
}