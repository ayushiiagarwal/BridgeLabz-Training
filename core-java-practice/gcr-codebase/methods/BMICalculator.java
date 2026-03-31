import java.util.*;
public class BMICalculator {

    public static double bmi(double weight, double height){
        return weight / (height*height);
    }

    public static String status(double bmi){
        if(bmi < 18.5) return "Underweight";
        else if(bmi < 25) return "Normal";
        else if(bmi < 30) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the weight(kg) and height(m) of the 10 members: ");
        double[][] data = new double[10][3];
        for(int i=0;i<10;i++){
                data[i][0] = sc.nextDouble(); // weight
                data[i][1] = sc.nextDouble(); // height
                data[i][2] = bmi(data[i][0], data[i][1]);
        }

        for(int i=0;i<10;i++){
            System.out.println("Person " + (i + 1) + 
                ": \nWeight: " + data[i][0] + 
                "\nHeight: " + data[i][1] + 
                " \nBMI: " + data[i][2] + 
                "\nStatus: " + status(data[i][2]));
        }

        sc.close();
    }
}
