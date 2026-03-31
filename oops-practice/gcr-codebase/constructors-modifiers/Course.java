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
        Course course1 = new Course("B.Tech", 4, 400000.0);
        Course course2 = new Course("L.L.B", 5, 800000.0);

        course1.displayCourseDetails();
        course2.displayCourseDetails();

    }

}
