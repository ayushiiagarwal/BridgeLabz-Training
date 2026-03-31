import java.lang.reflect.Method;

class Task {
    public void run() throws InterruptedException {
        Thread.sleep(600);
    }
}

public class ExecutionTime {
    public static void main(String[] args) throws Exception {
        Task object = new Task();
        Method method = Task.class.getMethod("run");

        long start = System.currentTimeMillis();
        method.invoke(object);
        long end = System.currentTimeMillis();

        System.out.println("Execution Time: " + (end - start) + " ms");
    }
}