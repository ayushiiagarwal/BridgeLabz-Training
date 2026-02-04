import java.io.*;

class User implements Serializable{
    String name;
    int age;

    User(String name, int age){
        this.name = name;
        this.age = age;
    }
}

public class DataSerialization {
    public static void main(String[] args) {
        User user = new User("Ayushi", 21);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("backup.dat"))){
            out.writeObject(user);
            System.out.println("Object backed up successfully!");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
