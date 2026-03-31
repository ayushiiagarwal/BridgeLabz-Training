import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod{
    String level() default "High";
}

class Work{

    @ImportantMethod(level = "Medium")
    void method1(){
        System.out.println("Method 1");
    }

    @ImportantMethod(level = "Low")
    void method2(){
        System.out.println("Method 2");
    }

    @ImportantMethod
    void method3(){
        System.out.println("Method 3 default");
    }
}


public class MarkImportantMethod {
    public static void main(String[] args) throws Exception{
        Method method1 = Work.class.getDeclaredMethod("method1");
        Method method2 = Work.class.getDeclaredMethod("method2");
        Method method3 = Work.class.getDeclaredMethod("method3");

        ImportantMethod n1 = method1.getAnnotation(ImportantMethod.class);
        ImportantMethod n2 = method2.getAnnotation(ImportantMethod.class);
        ImportantMethod n3 = method3.getAnnotation(ImportantMethod.class);

        System.out.println(n1.level());
        System.out.println(n2.level());
        System.out.println(n3.level());
    }
}