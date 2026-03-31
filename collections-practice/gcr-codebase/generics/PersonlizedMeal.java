import java.util.Scanner;

interface MealPlan{
    void mealType();
}

class VegetarianMeal implements MealPlan{
    public void mealType(){
        System.out.print("Vegetarian Meal");
    }
}

class VeganMeal implements MealPlan{
    public void mealType(){
        System.out.print("Vegan Meal");
    }
}

class KetoMeal implements MealPlan{
    public void mealType(){
        System.out.print("Keto Meal");
    }
}

class HighProteinMeal implements MealPlan{
    public void mealType(){
        System.out.print("High Protein Meal");
    }
}

class Meal<T extends MealPlan>{
    private T mealPlan;

    public Meal(T mealPlan){
        this.mealPlan = mealPlan;
    }

    public void showPlan(){
        mealPlan.mealType();
    }
}

class MealUtility{
    public static <T extends MealPlan> Meal<T> generatePlan(T plan){
        return new Meal<>(plan);
    }
}

public class PersonlizedMeal {
    public static void main(String[] args) {
        // Meal<VegetarianMeal> vegMeal = MealUtility.generatePlan((new VegetarianMeal()));
        // Meal<VeganMeal> veganMeal = MealUtility.generatePlan((new VeganMeal()));
        // Meal<KetoMeal> ketoMeal = MealUtility.generatePlan((new KetoMeal()));
        // Meal<HighProteinMeal> highProtienMeal = MealUtility.generatePlan((new HighProteinMeal()));

        // vegMeal.showPlan();
        // veganMeal.showPlan();
        // ketoMeal.showPlan();
        // highProtienMeal.showPlan();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your plan: ");
        System.out.println("1. Vegetarian Meal Plan\n" + 
                            "2. Vegan Meal Plan\n" +
                            "3. Keto Meal Plan\n" +
                            "4. High Protien Meal Plan");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                MealUtility.generatePlan(new VegetarianMeal()).showPlan();

                break;
            
            case 2:
                MealUtility.generatePlan(new VeganMeal()).showPlan();
                break;
        
            case 3:
                MealUtility.generatePlan(new KetoMeal()).showPlan();
                break;

            case 4:
                MealUtility.generatePlan(new HighProteinMeal()).showPlan();
                break;

            default:
                System.out.println("Invalid Choice! Vegetarian Meal is the defaut Meal Plan.\nPreparing Vegetarian Meal...");
                MealUtility.generatePlan(new VegetarianMeal());
                break;
        }

        sc.close();
    }
}
