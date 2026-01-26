import java.util.*;
class InvalidAgeException extends Exception{
    InvalidAgeException(String message){
        super(message);
    }
}

public class CustomException {

    static void validAge(int age) throws InvalidAgeException{
        if(age < 18) 
            throw new InvalidAgeException("Invalid Age! Must be 18 or above.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try{
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            validAge(age);
            System.out.println("Access Granted!");

            sc.close();
        }
        catch(InvalidAgeException e){
            System.out.println(e.getMessage());
        }
    }
}
