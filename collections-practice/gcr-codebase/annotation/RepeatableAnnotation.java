import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports{
    BugReport[] value(); 
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport{
    String description(); 
}

class ReportManager{

    @BugReport(description = "Memory leak")
    @BugReport(description = "Access denied")
    void reportBug(){
        System.out.println("Bug reported!");
    }
}

public class RepeatableAnnotation {
    public static void main(String[] args) throws Exception{
        Method method = ReportManager.class.getDeclaredMethod("reportBug");
        BugReport[] reports = method.getAnnotationsByType(BugReport.class);

        for(BugReport bug: reports){
            System.out.println("Bug: " + bug.description());
        }
    }
}