import java.util.Scanner;
public class Gameplay {
    static Game mainGame = new Game();
    public static void main(String[] args) {
        //display gameplay and get user confirmation
        if (displayRules()) {
            System.out.println("Happy playing!");
            //run game setup
            gameSetup();
        }else{
            System.out.println("Goodbye");
        }
    }

    /**
     * displays the rules and requires user confirmation
     * @return boolean indicating if user has accepted rules
     */
    public static boolean displayRules(){
        //display rules
        //TODO: add rules output
        System.out.println("Rules are as follows:");
        System.out.println("Evey player starts with seven cards.");
        System.out.println("There are two piles: a draw pile and a discard pile.");
        System.out.println("Your goal is to get rid of all your cards by playing one card at a time in the discard pile.");
        System.out.println("You can play a card if it matches the previously played card in either color, number, or action.");
        System.out.println("When you are at one card left, you need to shout \"UNO!\"."); //TODO: Daniel needs to pick which way we are doing UNO

        //create Scanner object
        Scanner userInput = new Scanner(System.in);
        System.out.println("Do you accept these rules?");
        System.out.println("Press any key to continue or type 'QUIT' to exit the game");

        //check for user input
        String input = userInput.next();
        userInput.close();
        if (input.equals("QUIT")) {
            return false;
        }else{
            return true;
        }

    }

    public static void gameSetup() {
        int input;
        Scanner userInput = new Scanner(System.in);
        do{
        //get number of players
        System.out.println("How many people will be playing (2-10 allowed): ");
        input = userInput.nextInt();
        mainGame.setPlayerCount(input);
        }while (input < 2 || input > 10);

        //get names of each player
        for (int i = 0; i < Game.getPlayerCount; i++) {
            System.out.println("Please enter player " +(i+1) +"'s name: ");
            mainGame.setPlayerNames(i, userInput.next);
        }
    }
}
