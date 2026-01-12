import java.util.*;

class CourseLimitExceededException extends Exception{
    public CourseLimitExceededException(String message){
        super(message);
    }
}

class Person{
    private String name;
    private String id;

    public Person(String name, String id){
        this.name = name;
        this.id = id;
    }
}

class Student extends Person{
    private List<String> courses;
    private List<String> grades;
    private static final int maxCourses = 3;

    public Student(String name, String id){
        super(name, id);
        this.courses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public void addCourse(String courseName) throws CourseLimitExceededException{
        if(courses.size() >= maxCourses)
            throw new CourseLimitExceededException("Course Limit Exceeded\n");

        courses.add(courseName);
        grades.add("N/A");
    }

    public void removeCourse(String courseName){
        int indx = courses.indexOf(courseName);
        if(indx != -1){
            courses.remove(indx);
            grades.remove(indx);
        }
    }

    public void assignGrade(String courseName, String grade){
        int indx = courses.indexOf(courseName);
        if(indx != -1){
            grades.set(indx, grade);
        }
    }
    public List<String> getCourses(){
        return courses;
    }

    public List<String> getGrades(){
        return grades;
    }
}

abstract class RegistrationService{
    public abstract void enroll(Student student, String courseName) throws CourseLimitExceededException;
    public abstract void drop(Student student, String courseName);
    public abstract void assignGrade(Student student, String courseName, String grade);
}

class Registration extends RegistrationService{
    @Override
    public void enroll(Student student, String courseName) throws CourseLimitExceededException{
        student.addCourse(courseName);
        System.out.println("Registered for: " + courseName);
    }

    @Override
    public void drop(Student student, String courseName){
        student.removeCourse(courseName);
        System.out.println("Dropped Course: " + courseName);
    }

    @Override
    public void assignGrade(Student student, String courseName, String grade){
        student.assignGrade(courseName, grade);
        System.out.println("Grade assigned for " + courseName);
    }
}


public class CourseRegistration {
    public static void main(String[] args) {
        Student student = new Student("Ayushi", "A101");
        RegistrationService service = new Registration();

        try{
            service.enroll(student, "Data Science");
            service.enroll(student, "BBA");
            service.enroll(student, "MBA");
            service.enroll(student, "B.Tech");
        }
        catch(CourseLimitExceededException e){
            System.out.println(e.getMessage());
        }

        service.assignGrade(student, "Data Science", "A+");
        service.assignGrade(student, "MBA", "B");

        System.out.println("\nCourses and Grades");
        for(int i=0;i<student.getCourses().size();i++){
            System.out.println(student.getCourses().get(i) + ": " + student.getGrades().get(i));
        }
    }
}
