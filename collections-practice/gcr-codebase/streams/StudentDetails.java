import java.io.*;

public class StudentDetails {
    public static void main(String[] args) throws IOException {

        DataOutputStream student = new DataOutputStream(new FileOutputStream("student.dat"));
        
        student.writeInt(101);
        student.writeUTF("Ayushi");
        student.writeDouble(8.7);

        student.close();

        DataInputStream dis = new DataInputStream(new FileInputStream("student.dat"));

        System.out.println("Roll: " + dis.readInt());
        System.out.println("Name: " + dis.readUTF());
        System.out.println("GPA: " + dis.readDouble());

        dis.close();
    }
}