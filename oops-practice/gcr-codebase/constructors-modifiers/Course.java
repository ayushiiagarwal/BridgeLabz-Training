class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "Institute of Technology";

    public Course(String courseName, int duration, double fee){
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    Course(){
        courseName = "B.Tech";
        duration = 4;
        fee = 100000.0;
    }

    void updateInstituteName(String name){
        instituteName = name;
    }

    void displayCourseDetails(){
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Duration: " + duration + " years");
        System.out.println("Course Fee: " + fee);
    }
    public static void main(String[] args) {
        Course course = new Course();
        course.displayCourseDetails();

    }

}
