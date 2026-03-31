import java.util.*;

abstract class CourseType{
    String name;

    CourseType(String name){
        this.name = name;
    }

    abstract void evaluationMethod();
}

class ExamCourse extends CourseType{
    ExamCourse(String name){
        super(name);
    }

    void evaluationMethod(){
        System.out.println("Evaluation through Exam");
    }
}

class AssignmentCourse extends CourseType{
    AssignmentCourse(String name){
        super(name);
    }

    void evaluationMethod(){
        System.out.println("Evaluation through Assignments");
    }
}

class ResearchCourse extends CourseType{
    ResearchCourse(String name){
        super(name);
    }

    void evaluationMethod(){
        System.out.println("Evaluation through Research");
    }
}

class Course<T extends CourseType>{
    private String courseName;
    private T courseType;

    Course(String courseName, T courseType){
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public void showDetails(){
        System.out.println("Course: " + courseName);
        courseType.evaluationMethod();
    }
}

class CourseUtility{
    static void evaluate(List<? extends CourseType> courses){
        for(CourseType course : courses)
            course.evaluationMethod();
    }
}

public class CourseManagement{
    public static void main(String[] args) {
        Course<ExamCourse> course1 = new Course<>("Data Science", new ExamCourse(null));
        Course<AssignmentCourse> course2 = new Course<>("Python Course", new AssignmentCourse(null));
        Course<ResearchCourse> course3 = new Course<>("AI Research", new ResearchCourse(null));

        course1.showDetails();
        System.out.println();
        course2.showDetails();
        System.out.println();
        course3.showDetails();

        System.out.println("\nAll Evaluation Methods: ");

        List<CourseType> courseTypes = new ArrayList<>();
        courseTypes.add(new ExamCourse(null));
        courseTypes.add(new AssignmentCourse(null));
        courseTypes.add(new ResearchCourse(null));

        CourseUtility.evaluate(courseTypes);
    }
}