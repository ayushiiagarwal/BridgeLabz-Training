import java.util.*;

public class RockPaperScissors {
    public static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        return choices[(int)(Math.random() * 3)];
    }

    public static String getResult(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("scissors") && computer.equals("paper")) ||
            (user.equals("paper") && computer.equals("rock"))) return "User";
        return "Computer";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userWins = 0, computerWins = 0, draws = 0;

        System.out.println("Enter the number of games: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("Round " + i + " - Enter rock, paper or scissors: ");
            String user = sc.nextLine().toLowerCase();
            String computer = getComputerChoice();
            String result = getResult(user, computer);
            System.out.println("Computer chose: " + computer + " → " + result + " wins");
            if (result.equals("User")) userWins++;
            else if (result.equals("Computer")) computerWins++;
            else draws++;
        }

        System.out.println("\nResults:");
        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Draws: " + draws);
        System.out.println("User Win %: " + (userWins * 100.0 / n));
        System.out.println("Computer Win %: " + (computerWins * 100.0 / n));

        sc.close();
    }
}