import java.util.*;

class InvalidMarkException extends Exception{
    public InvalidMarkException(String message){
        super(message);
    }
}

class Student{
    private String name;
    private String[] subjects;
    private int[] marks;

    public Student(String name, String[] subjects, int[] marks) throws InvalidMarkException{
        for(int m : marks){
            if(m < 0 || m > 100)
                throw new InvalidMarkException("Mark must be between 0-100.");
        }
    this.name = name;
    this.subjects = subjects;
    this.marks = marks;
    }

    public double calculateAverage(){
        double sum = 0;
        for(int m : marks){
            sum += m;
        }
        return sum/marks.length;
    }

    public String getGrade(){
        double average = calculateAverage();
        if(average >= 90) return "A";
        if(average >= 80) return "B";
        if(average >= 70) return "C";
        if(average >= 60) return "D";
        return "E";
    }

    public void displayResult(){
        System.out.println("Name: " + name);
        for(int i=0;i<subjects.length;i++){
            System.out.printf("%-10s : %d\n", subjects[i], marks[i]);
        }
        System.out.println("Average Score: " + calculateAverage());
        System.out.println("Grade: " + getGrade());
        System.out.println();
    }
}

public class ReportGenerator {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        String[] subjects = {"Physics ", "Chemistry ", "Maths"};

        try{
            int[] marks1 = {78, 70, 89};
            studentList.add(new Student("Shreyansh ", subjects, marks1));

            int[] marks2 = {80, 79, 95};
            studentList.add(new Student("Sam ", subjects, marks2));
        }catch(InvalidMarkException e){
            System.out.println(e.getMessage());
        }

        for(Student s : studentList){
            s.displayResult();
        }
    }
}
