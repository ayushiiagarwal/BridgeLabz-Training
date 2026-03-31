public class Student{
    String name, rollNumber;
    double[] marks;

    Student(String name, String rollNumber, double[] marks){

        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;

    }

    public char calculateGrade(){
        double total = 0;
        for (double mark : marks){
            total += mark;
        }
        double average = total / marks.length;

        if (average >= 80) return 'A';
        else if (average >= 70) return 'B';
        else if (average >= 50) return 'C';
        else return 'D';
    }

    public void display(){
        System.out.println("Student Name: " + name);
        System.out.println("Student Roll Number: " + rollNumber);
        System.out.println("Student Marks:");
        for (int i = 0; i < marks.length; i++){
            System.out.println("Mark" + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Grade " + calculateGrade());
    }
    public static void main(String[] args){

        double[] marks1 = {80.0, 70.0, 75.0};
        Student s1 = new Student("Thamarai", "ECE001", marks1);
        s1.display();

        System.out.println("---------------------------");

        double[] marks2 = {60.0, 65.0, 50.0};
        Student s2 = new Student("Kannan", "CSC002", marks2);
        s2.display();

        System.out.println("---------------------------");
    }
}
