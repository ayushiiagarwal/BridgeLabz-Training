import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

class Student{
    private String name, grade;

    public Student(String name, String grade){
        this.name = name;
        this.grade = grade;
    }

    public String getName(){ return name; }
    public String getGrade(){ return grade; }
}

public class StudentResult{
    public static void main(String[] args) {
        Map<String, List<String>> students = Stream.of(
            new Student("Ayushi", "Grade 10"),
            new Student("Shruti", "Grade 11"),
            new Student("Rahul", "Grade 10"),
            new Student("Alankrati", "Grade 9")
        ).collect(Collectors
            .groupingBy(
                Student::getGrade, 
                Collectors.mapping(
                    Student::getName, 
                    Collectors.toList()))
        );

        students.forEach((grade, name) -> System.out.println(grade + ": " + name));
    }
}