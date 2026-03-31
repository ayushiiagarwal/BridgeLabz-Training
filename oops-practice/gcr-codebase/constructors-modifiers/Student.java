class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA){
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA(){
        return CGPA;
    }

    public void setCGPA(double CGPA){
        this.CGPA = CGPA;
    }
}

class PostGraduateStudent extends Student{
        public PostGraduateStudent(int rollNumber, String name, double CGPA){
            super(rollNumber, name, CGPA);
        }

        public void showName(){
            System.out.println("Post-Graduate Student name: " + name);
        }

        public static void main(String[] args) {
            PostGraduateStudent pg = new PostGraduateStudent(1, "Ayushi", 8.7);
            pg.showName();
        }
    }
