class Animal{
    String name;
    int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void makeSound(){
        System.out.println("The Animal makes a sounds");
    }
}

class Dog extends Animal{
    Dog(String name, int age){
        super(name, age);
    }

    @Override
    public void makeSound(){
        System.out.println(name + " barks");
    }
}

class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " meows");
    }
}

class Bird extends Animal{
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " tweets");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal dog = new Dog("Snowie", 9);
        Animal cat = new Cat("Crookshanks", 10);
        Animal bird = new Bird("Hedwig", 12);

        System.out.println("-----Animal Sounds-----");
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}