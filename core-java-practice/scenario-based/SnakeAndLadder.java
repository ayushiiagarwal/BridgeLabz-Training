import java.util.Random;
public class SnakeAndLadder {
    public static final int noPlay = 0;
    public static final int ladder = 1;
    public static final int snake = 2;
    public static final int winningPosition = 100; 

    public static int useCase2() {
        Random random = new Random();
        return random.nextInt(6) + 1; 
    }

    public static int useCase3() {
        Random random = new Random();
        return random.nextInt(3); 
    }

    public static int calculatePosition(int currentPosition, int diceValue, int option) {
        switch (option) {
            case ladder:
                if (currentPosition + diceValue <= winningPosition) {
                    currentPosition += diceValue; 
                }
                break;
            case snake:
                currentPosition -= diceValue;  
                if (currentPosition < 0) {
                    currentPosition = 0;
                }
                break;
            case noPlay:
                break;
        }
        return currentPosition;
    }

    public static void useCase7() {
        int player1Position = 0;  
        int player2Position = 0;
        int diceCountP1 = 0;
        int diceCountP2 = 0;
        boolean player1 = true;

        System.out.println("Game started! Both players are at position 0.");

        while (player1Position < winningPosition && player2Position < winningPosition) {
            int diceValue = useCase2();
            int option = useCase3();
            
            if (player1) {
                diceCountP1++;
                player1Position = calculatePosition(player1Position, diceValue, option);
                System.out.println("Player 1 rolled " + diceValue + ", Position: " + player1Position);
                
                if (option != ladder) {
                    player1 = false;
                }
            } else {
                diceCountP2++;
                player2Position = calculatePosition(player2Position, diceValue, option);
                System.out.println("Player 2 rolled " + diceValue + ", Position: " + player2Position);
                
                if (option != ladder) {
                    player1 = true;
                }
            }
        }

        if (player1Position == winningPosition) {
            System.out.println("\nPLAYER 1 WON THE GAME!");
            System.out.println("Total dice rolls by Player 1: " + diceCountP1);
        } else {
            System.out.println("\nPLAYER 2 WON THE GAME!");
            System.out.println("Total dice rolls by Player 2: " + diceCountP2);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Line Comparison Computation Program");
        useCase7();
    }
}