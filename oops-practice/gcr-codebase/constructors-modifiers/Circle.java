public class Circle {
    double radius;

    public Circle() {
        radius = 5.0;
       
    }

    public Circle(double radius, String color) {
        this.radius = radius;

    }

    public void display() {
        System.out.println("Radius: " + radius);
    }
}
