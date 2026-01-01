public class Student {
    private static String universityName = "Global University";
    private String name;
    private final int rollNumber;
    private char grade;
    private static int totalStudents = 0;

    public Student(int rollNumber, String name, char grade){
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public void displayStudentDetails(){
        if(this instanceof Student){
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
            System.out.println();
        }
    }

    public void updateGrade(){
        char newGrade = 'A';
        System.out.println("Grade updated to: " + newGrade);
    }
    
    public static void displayTotalStudents(){
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public static void main(String[] args) {
        Student s1 = new Student(101, "Hemashree", 'A');
        Student s2 = new Student(102, "Sharmila", 'B');

        displayTotalStudents();
        s1.displayStudentDetails();
        s2.displayStudentDetails();
        s2.updateGrade();
        s2.displayStudentDetails();
    }
}
