package Cards;
import java.util.Scanner;

import src.*;

public class WildCard extends Card {
    /**
     * Constructor
     * 
     * @param cardColor enum type, color of the card
     */
    public WildCard() {
        super(Colors.WILD, "Wild");
    }

    @Override
    public int doAction(int currentPlayer) {
        Scanner sc = new Scanner(System.in);
        //get new color
        System.out.println("What color would you like: [1] Red, [2] Yellow, [3] Green, [4] Blue");
        int userChoice;
        do {
            System.out.println("Please choose a number (1-4)");
            userChoice = sc.nextInt();
        }while(userChoice >= 4 && userChoice <= 1);

        Colors chosenColor;
        switch (userChoice) {
            case 1:
                chosenColor = Colors.RED;
                break;
            case 2:
                chosenColor = Colors.YELLOW;
                break;
            case 3:
                chosenColor = Colors.GREEN;
                break;
            case 4:
                chosenColor = Colors.BLUE;
                break;
            default:
                chosenColor = Colors.RED;
                break;
        }

        //display color
        System.out.println("The color chosen is " +chosenColor.toString());
        this.setColor(chosenColor);

        //set nextplayer
        int nextPlayer;
        if (Gameplay.getGameDirection()) {
            nextPlayer = (currentPlayer + 1) >= Gameplay.getMainGame().getPlayerCount() ? 0 : ++currentPlayer;
        }else{
            nextPlayer = currentPlayer == 0 ? Gameplay.getMainGame().getPlayerCount()-1 : --currentPlayer;
        }
        // return next player to play
        return nextPlayer;
    }

    @Override
    public String toString() {
        return "Wild";
    }
}
