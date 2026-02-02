import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo{
    String priority();
    String assignedTo();
}

class TaskManager{

    @TaskInfo(priority = "High", assignedTo = "Adam")
    void completeTask(){
        System.out.println("Task completed.");
    }
}

public class CustomAnnotation {
    public static void main(String[] args) throws Exception{
        TaskManager manager = new TaskManager();

        Method method = manager.getClass().getDeclaredMethod("completeTask");
        TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

        System.out.println("Priority: " + taskInfo.priority());
        System.out.println("Assigned to: " + taskInfo.assignedTo());
    }
}