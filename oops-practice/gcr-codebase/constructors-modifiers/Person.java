public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(Person other) {
        this.name = "Ayushi";
        this.age = 21;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
