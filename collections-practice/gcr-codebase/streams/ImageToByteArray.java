import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("image.jpg");
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        int data;
        while ((data = fis.read()) != -1) {
            os.write(data);
        }

        byte[] imageBytes = os.toByteArray();

        ByteArrayInputStream is = new ByteArrayInputStream(imageBytes);
        FileOutputStream fos = new FileOutputStream("newimage.jpg");

        while ((data = is.read()) != -1) {
            fos.write(data);
        }

        fis.close();
        fos.close();

        System.out.println("Image copied successfully");
    }
}