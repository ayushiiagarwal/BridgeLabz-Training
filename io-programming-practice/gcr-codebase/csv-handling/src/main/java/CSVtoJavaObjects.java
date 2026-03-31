import java.util.*;
import com.opencsv.*;
import java.io.*;

class Student {
    private int id;
    private String name;
    private int age;
    private int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + age + " | " + marks;
    }
}

public class CSVtoJavaObjects {
    public static void main(String[] args) throws Exception{
        List<Student> students = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader("files/students.csv"));
        String[] row;

        reader.readNext();
        while ((row = reader.readNext()) != null) {
            students.add(new Student(
                Integer.parseInt(row[0]),
                row[1],
                Integer.parseInt(row[2]),
                Integer.parseInt(row[3])
            ));
        }
        reader.close();
        students.forEach(System.out::println);
    }
}
