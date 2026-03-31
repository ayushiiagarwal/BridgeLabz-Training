class Person{
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Teacher extends Person{
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println(name + " teaches " + subject);
    }
}

class Student extends Person{
    int grade;

    Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println(name + " is in grade " + grade);
    }   
}

class Staff extends Person{
    String position;

    Staff(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    void displayRole() {
        System.out.println(name + " works as " + position);
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Sharma", 50, "Mathematics");
        teacher.displayRole();

        Student student = new Student("Kaylee", 19, 12);
        student.displayRole();

        Staff staff = new Staff("Suresh", 40, "Librarian");
        staff.displayRole();
        
    }
}
