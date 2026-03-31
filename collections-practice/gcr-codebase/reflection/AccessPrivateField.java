import java.lang.reflect.Field;

class Person {
    private int age = 20;
}

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person();

        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);

        field.set(person, 22);  
        System.out.println("Age: " + field.get(person));
    }
}