import java.io.*;

public class PipedStreams {
    public static void main(String[] args) throws IOException {
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(out);

        Thread writer = new Thread(() -> {
            try {
                out.write("Hello ".getBytes());
                out.close();
            } catch (IOException e) {
                System.out.println("Writer fail.");
            }
        });
        

        Thread reader = new Thread(() -> {
            try {
                int ch;
                while ((ch = in.read()) != -1) {
                    System.out.print((char) ch);
                }
                in.close();
            } catch (IOException e) {
                System.out.println("Reader fail.");
            }
        });

        writer.start();
        reader.start();
    }
}