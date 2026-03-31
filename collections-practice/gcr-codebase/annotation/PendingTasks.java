import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project{

    @Todo(task = "Implement feature 1", assignedTo = "Adam")
    void task1(){
        System.out.println("DO TASK 1");
    }

    @Todo(task = "Implement feature 2", assignedTo = "Liam", priority = "HIGH")
    void task2(){
        System.out.println("DO TASK 2");
    }

    @Todo(task = "Implement feature 3", assignedTo = "Olibve", priority = "LOW")
    void task3(){
        System.out.println("DO TASK 3");
    }
}


public class PendingTasks {
    public static void main(String[] args) throws Exception{
        Method method1 = Project.class.getDeclaredMethod("task1");
        Method method2 = Project.class.getDeclaredMethod("task2");
        Method method3 = Project.class.getDeclaredMethod("task3");

        Todo t1 = method1.getAnnotation(Todo.class);
        Todo t2 = method2.getAnnotation(Todo.class);
        Todo t3 = method3.getAnnotation(Todo.class);

        System.out.println(t1.task() + " - " + t1.assignedTo() + " - " + t1.priority());
        System.out.println(t2.task() + " - " + t2.assignedTo() + " - " + t2.priority());
        System.out.println(t3.task() + " - " + t3.assignedTo() + " - " + t3.priority());
    }
}