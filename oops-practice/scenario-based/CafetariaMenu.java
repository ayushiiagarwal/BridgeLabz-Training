import java.util.Scanner;

public class CafetariaMenu {
    private static String[] menu = {
        "Veg Burger", "Kurkure Wrap", "Farm House Pizza", 
        "Alfredo Pasta", "Nachos", "French Fries", 
        "Cold Coffee", "Fruit Bowl", "Grill Sandwich", "Ginger Tea"
    };

    public static void displayMenu() {
        System.out.println("----- CAMPUS CAFETERIA MENU -----");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }
        System.out.println("---------------------------------");
    }

    public static String getItemByIndex(int index) {
        int currentIndex = index - 1;

        if (currentIndex >= 0 && currentIndex < menu.length) {
            return menu[currentIndex];
        } else {
            return null; 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        displayMenu();

        System.out.print("Enter the item number you wish to order: ");
        if (sc.hasNextInt()) {
            int choice = sc.nextInt();
            
            String selectedItem = getItemByIndex(choice);

            if (selectedItem != null) {
                System.out.println("\nOrder Confirmed: You selected " + selectedItem);
            } else {
                System.out.println("Invalid selection. Please choose between 1 and 10.");
            }
        } else {
            System.out.println("Please enter a valid number.");
        }
        
        sc.close();
    }
}
