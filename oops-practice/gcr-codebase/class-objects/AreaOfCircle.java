public class AreaOfCircle {
    double radius;

    AreaOfCircle(double radius){
        this.radius = radius;
    }

    public void circumference(){
        System.out.printf("Circumference: %.4f", (Math.PI*radius));
    }
    
    public void area(){
        System.out.printf("\nArea of Circle: %.4f", (Math.PI*radius*radius));
    }
    public static void main(String[] args) {
        AreaOfCircle circle = new AreaOfCircle(3.5);
        
        circle.area();

        circle.circumference();
    }
}
