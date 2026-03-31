import com.fasterxml.jackson.databind.ObjectMapper;

class Car{
    public String model, number;

    public Car(String model, String number){
        this.model = model;
        this.number = number;
    }
}

public class ObjectToJSON {
    public static void main(String[] args) throws Exception{
        ObjectMapper object = new ObjectMapper();
        Car car = new Car("Audi", "AB02154");

        String jsonString = object.writeValueAsString(car);
        System.out.println("Convert Java Object to JSON");
        System.out.println(jsonString);
        System.out.println();
    }
}
