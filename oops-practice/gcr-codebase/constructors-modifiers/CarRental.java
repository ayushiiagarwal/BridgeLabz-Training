public class CarRental {
    String customerName, carModel;
    int rentalDays;

    public CarRental(String name, String model, int days){
        this.customerName = name;
        this.carModel = model;
        this.rentalDays = days;
    }

    public CarRental(){
        this.customerName = "Olive Smith";
        this.carModel = "Honda Civic";
        this.rentalDays = 10;
    }

    public double totalCost(double price){
        return price * rentalDays;
    }

    public void display(){
        System.out.println("Customer Name: " + customerName + "\nCar Model: " + carModel + "\nRental Days: " + rentalDays);
        System.out.println("Total Cost: " + totalCost(3000.0));
    }
    public static void main(String[] args) {
        CarRental rent = new CarRental();
        rent.display();
    }
    
}
