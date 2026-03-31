import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class Calculator {

    @CacheResult
    public int square(int n) {
        System.out.println("Computing...");
        return n * n;
    }
}

public class CustomCaching {

    static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Method method = Calculator.class.getMethod("square", int.class);

        System.out.println(call(calc, method, 5));
        System.out.println(call(calc, method, 6)); 
    }

    static int call(Calculator obj, Method m, int arg) throws Exception {
       
        if (m.isAnnotationPresent(CacheResult.class) && cache.containsKey(arg))
            return cache.get(arg);
    
        int result = (int) m.invoke(obj, arg);
        cache.put(arg, result);
        return result;
    }
}