class Animal{
    void makeSound(){
        System.out.println("No generic sound.");
    }
}

class Dog extends Animal{
    @Override
    void makeSound(){
        System.out.println("Dog's woof!");
    }
}

public class OverrideUse{
    public static void main(String[] args){
        Dog dog = new Dog();
        dog.makeSound(); 
    }
}