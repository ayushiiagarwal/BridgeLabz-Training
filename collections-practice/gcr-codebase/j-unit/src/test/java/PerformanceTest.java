import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PerformanceTest {
    @Test
    @Timeout(10)
    void testLongRunningTaskTimeout() throws InterruptedException {
        Performance task = new Performance();
        assertEquals("Task Completed", task.longRunningTask());
        
    }
}
