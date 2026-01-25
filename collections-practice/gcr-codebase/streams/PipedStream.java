import java.io.*;

class WriterThread extends Thread {
    PipedOutputStream os;

    WriterThread(PipedOutputStream os) {
        this.os = os;
    }

    public void run() {
        try {
            os.write("Hello there!".getBytes());
            os.close();
        } catch (IOException e) {
            e.getMessage();
            System.out.println("Writer Fail.");
        }
    }
}

class ReaderThread extends Thread {
    PipedInputStream is;

    ReaderThread(PipedInputStream is) {
        this.is = is;
    }

    public void run() {
        try {
            int data;
            while ((data = is.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.getMessage();
            System.out.println("Reader Fail.");
        }
    }
}

public class PipedStream {
    public static void main(String[] args) throws IOException {
        PipedInputStream is = new PipedInputStream();
        PipedOutputStream os = new PipedOutputStream(is);

        new WriterThread(os).start();
        new ReaderThread(is).start();
    }
}