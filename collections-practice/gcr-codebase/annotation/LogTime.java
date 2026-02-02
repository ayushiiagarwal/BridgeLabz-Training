import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime{
    String message() default "Method executed in: ";
}

class Service{
    @LogExecutionTime(message = "Time taken: ")
    void processData(){
        System.out.println("Processing data...");
    }

    @LogExecutionTime
    void optimization(){
        System.out.println("optimizing");
        System.out.println("the");
        System.out.println("code.");
    }
}

public class LogTime {
    public static void main(String[] args) throws Exception{

        Service service = new Service();
        Method method1 = Service.class.getDeclaredMethod("processData");
        Method method2 = Service.class.getDeclaredMethod("optimization");

        if(method1.isAnnotationPresent(LogExecutionTime.class)){
            LogExecutionTime annotation = method1.getAnnotation(LogExecutionTime.class);
            long stTime = System.currentTimeMillis();
            service.processData();
            long endTime = System.currentTimeMillis();
            System.out.println(annotation.message() + (endTime-stTime) + "ms");
        }

        if(method2.isAnnotationPresent(LogExecutionTime.class)){
            LogExecutionTime annotation = method2.getAnnotation(LogExecutionTime.class);
            long stTime = System.currentTimeMillis();
            service.optimization();
            long endTime = System.currentTimeMillis();
            System.out.println(annotation.message() + (endTime-stTime) + "ms");
        }
    }
}