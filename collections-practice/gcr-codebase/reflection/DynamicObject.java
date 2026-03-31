class Student {
    public Student() {
        System.out.println("Student object created");
    }
}

public class DynamicObject {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Student");
        Object obj = cls.getDeclaredConstructor().newInstance();
    }
}