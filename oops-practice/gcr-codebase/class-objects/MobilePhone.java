public class MobilePhone {
    String brand, model;
    double price;

    MobilePhone(String brand, String model, Double price){
        this.brand = brand;
        this.model = model;
        this.price = price;

    }

    public void display(){
        System.out.println("Brand of Mobile: " + brand);
        System.out.println("Model of Mobile: " + model);
        System.out.println("Price of mobile: " + price);
    }
    public static void main(String[] args) {
        MobilePhone phone1 = new MobilePhone("VIVO", "VIVO V29", 15999.0);
        MobilePhone phone2 = new MobilePhone("ONE PLUS", "ONE PLUS nord4", 39999.0);
        MobilePhone phone3 = new MobilePhone("APPLE", "iphone pro16", 79999.0);

        phone1.display();
        System.out.println("-----------------------------");
        phone2.display();
        System.out.println("-----------------------------");
        phone3.display();
        System.out.println("-----------------------------");
    }
}
