import java.util.*;

public class CircularBuffer {
    public static void main(String[] args) {
        int bufferSize = 3;
        Queue<Integer> buffer = new ArrayDeque<>();

        insert(buffer, bufferSize, 1);
        insert(buffer, bufferSize, 2);
        insert(buffer, bufferSize, 3);
        insert(buffer, bufferSize, 4);  

        System.out.println("Buffer: " + buffer);
    }

    static void insert(Queue<Integer> buffer, int size, int value) {
        if (buffer.size() == size) {
            buffer.poll(); 
        }
        buffer.offer(value);
    }
}
