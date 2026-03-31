class Student implements Cloneable{
    String name;
    int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

public class CloneObject {
    public static void main(String[] args) {
        try{
            Student s1 = new Student("Ayushi", 21);
            Student s2 = (Student) s1.clone();

            System.out.println("Original: \nName: " + s1.name + " | Age: " + s1.age);
            System.out.println("\nCloned: \nName: " + s2.name + " | Age: " + s2.age);
        }

        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
