import java.io.*;

public class BufferedVsUnbuffered {
    public static void main(String[] args) throws Exception {

        File src = new File("input.txt");
        File dest1 = new File("unbuffered.dat");
        File dest2 = new File("buffered.dat");

        long start = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest1)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
        long end = System.nanoTime();
        System.out.println("Unbuffered Time: " + (end - start));

        
        start = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest2))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
        end = System.nanoTime();
        System.out.println("Buffered Time: " + (end - start));
    }
}